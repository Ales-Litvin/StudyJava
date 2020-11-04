package by_epam.introduction_to_java.tasks_6.task03.server;

import by_epam.introduction_to_java.tasks_6.task03.Connection;
import by_epam.introduction_to_java.tasks_6.task03.ConsoleHelper;

import by_epam.introduction_to_java.tasks_6.task03.entity.Dossier;
import by_epam.introduction_to_java.tasks_6.task03.entity.message.Message;
import by_epam.introduction_to_java.tasks_6.task03.entity.message.MessageType;
import by_epam.introduction_to_java.tasks_6.task03.entity.user.User;
import by_epam.introduction_to_java.tasks_6.task03.entity.user.UserRole;
import by_epam.introduction_to_java.tasks_6.task03.server.utils.Dossiers;
import by_epam.introduction_to_java.tasks_6.task03.server.utils.SecurityUtils;
import by_epam.introduction_to_java.tasks_6.task03.server.utils.Users;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;



/**
 * It's class server.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("Введите порт сревера...");
        ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt());
        ConsoleHelper.writeMessage("Сервер запущен!");

        try {
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Произошла ошибка.");
            serverSocket.close();
        }
    }

    /**
     * User database.
     */
    private static final Users USERS_DATABASE = Users.getInstance();

    /**
     * Dossier database.
     */
    private static final Dossiers DOSSIERS_DATABASE = Dossiers.getInstance();

    // карта для хранения пользователей
    private static final Map<User, Connection> USER_CONNECTION_MAP = new ConcurrentHashMap<>();

    /**
     * Sends the message to the User.
     * @param message the message for sending.
     * @param user the message recipient.
     */
    public static void sendMessage(Message message, User user){
        try {
            USER_CONNECTION_MAP.get(user).send(message);
        } catch (IOException e){
            ConsoleHelper.writeMessage("Сообщение не доставлено.");
        }
    }

    // Класс для обработки запросов пользователей в отдельной нити.
    private static class Handler extends Thread{
        private final Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        // регистрирует нового пользователя, соединяется с ним и заносит сооединение в map.

        /**
         * Adds new the User in the {@code USER_CONNECTION_MAP}
         * @param connection connection for sending the message.
         * @return new the User
         * @throws IOException
         * @throws ClassNotFoundException
         */
        private User serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(null, MessageType.USER_REQUEST, "Sign in, please..."));
                Message message = connection.receive();

                // Client's "User".
                User newUser = message.getUser();

                if (message.getType().equals(MessageType.USER_DATA) && newUser != null) {

                    // "User" from dataBase.
                    User dataBaseUser = USERS_DATABASE.get(newUser.getName(), newUser.getPassword());

                    if (dataBaseUser != null && !USER_CONNECTION_MAP.containsKey(dataBaseUser)) {
                        USER_CONNECTION_MAP.put(dataBaseUser, connection);

                        connection.send(new Message(null,
                                MessageType.USER_ACCEPTED,
                                "Logged in"));
                        return dataBaseUser;
                    }
                }
            }
        }

        // основной цикл отвечает на соответствующий запрос пользователя
        //
        private void serverMainLoop(Connection connection, User currentUser) throws IOException,  ClassNotFoundException{
            while (true) {
                Message message = connection.receive();

                switch (message.getType()){
                    case GET_DOSSIER:
                        int id = (int) message.getData();

                        if (SecurityUtils.hasPermission(currentUser, UserRole.USER)){
                            Dossier dossier = DOSSIERS_DATABASE.get(id);
                            sendMessage(new Message(null, MessageType.DOSSIER, dossier), currentUser);
                        } else {
                            sendMessage(
                                    new Message(null,
                                            MessageType.TEXT,
                                            currentUser.getName() + ": " + "Недостаточно прав доступа"),
                                    currentUser);
                        }
                    break;
                    case CHANGE_DOSSIER:
                        Dossier dossier = (Dossier) message.getData();

                        if (SecurityUtils.hasPermission(currentUser, UserRole.ADMIN)){
                            DOSSIERS_DATABASE.change(dossier);

                            String text = "Dossier: id{" + dossier.getId() + "} changed!";

                            sendMessage(new Message(null, MessageType.TEXT, text), currentUser);
                        } else {
                            sendMessage(
                                    new Message(null, MessageType.TEXT,
                                            currentUser.getName() + ": " + "Недостаточно прав доступа"),
                                    currentUser);
                        }
                        break;
                    case ADD_DOSSIER:
                        Dossier dossier1 = (Dossier) message.getData();

                        if (SecurityUtils.hasPermission(currentUser, UserRole.ADMIN)){
                            DOSSIERS_DATABASE.add((Dossier) message.getData());

                            String text = "Dossier: id{" + dossier1.getId() + "} added!";
                            sendMessage(new Message(null, MessageType.TEXT, text), currentUser);
                        } else {
                            sendMessage(
                                    new Message(null,
                                            MessageType.TEXT,
                                            currentUser.getName() + ": " + "Недостаточно прав доступа!"),
                                    currentUser);
                        }
                        break;
                    default:
                        String stringMessage =
                                "'" + message.getData() + "' - это неизвестная команада.";
                        sendMessage(new Message(null, MessageType.TEXT, stringMessage), currentUser);
                        ConsoleHelper.writeMessage("Не удалось разобрать запрос пользователя.");
                        break;
                }
            }
        }

        public void run(){
            ConsoleHelper.writeMessage(socket.getRemoteSocketAddress().toString());

            User currentUser = null;

            try (Connection connection = new Connection(socket)) {
                currentUser = serverHandshake(connection);

                serverMainLoop(connection, currentUser);
            } catch (IOException | ClassNotFoundException e){
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с сервером");
            }

            try {
                USER_CONNECTION_MAP.remove(currentUser);
                sendMessage(new Message (null, MessageType.USER_REMOVED, null), currentUser);
                ConsoleHelper.writeMessage("Сооединение с удаленным сервером закрыто");
            } catch (Exception eE){
                ConsoleHelper.writeMessage("Произошла ошибка при удалении пользователя");
            }
        }
    }
}