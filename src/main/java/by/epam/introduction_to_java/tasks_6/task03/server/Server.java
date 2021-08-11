package by.epam.introduction_to_java.tasks_6.task03.server;

/*
 * Попробуйте решить данную задачу хотя бы на 50%.
 * Задание 3: создайте клиент-серверное приложение “Архив”.
 * Общие требования к заданию:
 * • В архиве хранятся Дела (например, студентов). Архив находится на сервере.
 * • Клиент, в зависимости от прав, может запросить дело на просмотр, внести в
 * него изменения, или создать новое дело.
 *
 * Требования к коду лабораторной работы:
 * • Для реализации сетевого соединения используйте сокеты.
 * • Формат хранения данных на сервере – xml-файлы.
 */

import by.epam.introduction_to_java.tasks_6.task03.server.utils.Dossiers;
import by.epam.introduction_to_java.tasks_6.task03.server.utils.SecurityUtils;
import by.epam.introduction_to_java.tasks_6.task03.server.utils.Users;
import by.epam.introduction_to_java.tasks_6.task03.Connection;
import by.epam.introduction_to_java.tasks_6.task03.ConsoleHelper;

import by.epam.introduction_to_java.tasks_6.task03.entity.Dossier;
import by.epam.introduction_to_java.tasks_6.task03.entity.message.Message;
import by.epam.introduction_to_java.tasks_6.task03.entity.message.MessageType;
import by.epam.introduction_to_java.tasks_6.task03.entity.user.User;
import by.epam.introduction_to_java.tasks_6.task03.entity.user.UserRole;

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

    /**
     * Map for user and connection.
     */
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

    /**
     * The class for handling user request in the Thread.
     * (Обрабатывает запросы пользователя в отдельном The thread)
     */
    private static class Handler extends Thread{
        private final Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

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
                        ConsoleHelper.writeMessage("Добавлен пользователь: " + dataBaseUser.toString());
                        connection.send(new Message(null,
                                MessageType.USER_ACCEPTED,
                                "Logged in"));
                        return dataBaseUser;
                    }
                }
            }
        }

        /**
         * Main loop for handling user's request.
         * @param connection connection for send message.
         * @param currentUser original user current connection.
         * @throws IOException
         * @throws ClassNotFoundException
         */
        private void serverMainLoop(Connection connection, User currentUser) throws IOException,  ClassNotFoundException{
            while (true) {
                Message message = connection.receive();

                // just writes incoming message to console (you need see, how work this method)
                ConsoleHelper.writeMessage(message.toString());

                Dossier dossier = null;

                switch (message.getType()){
                    case GET_DOSSIER:
                        long id = (long) message.getData();
                        dossier = DOSSIERS_DATABASE.get(id);

                        if (SecurityUtils.hasPermission(currentUser, UserRole.USER) && dossier != null){
                            sendMessage(new Message(null, MessageType.DOSSIER, dossier), currentUser);
                        } else if (SecurityUtils.hasPermission(currentUser, UserRole.USER) && dossier == null){
                            String text = "Dossier with the ID number '" + id + "' doesn't exist.";

                            sendMessage(new Message(null, MessageType.TEXT, text), currentUser);
                        } else {
                            String text = "Недостаточно прав доступа для пользователя '" + currentUser.getName() + "'.";

                            sendMessage(new Message(null, MessageType.TEXT, text), currentUser);
                        }
                        break;
                    case CHANGE_DOSSIER:
                        dossier = (Dossier) message.getData();

                        if (SecurityUtils.hasPermission(currentUser, UserRole.ADMIN) &&
                                DOSSIERS_DATABASE.change(dossier)){
                            String text = dossier.toString() + " - changed!";

                            sendMessage(new Message(null, MessageType.TEXT, text), currentUser);
                        } else {
                            String text = "Недостаточно прав доступа для пользователя " +
                                    "'" + currentUser.getName() + "' или дело с заданным ID не существует.";

                            sendMessage(new Message(null, MessageType.TEXT, text), currentUser);
                        }
                        break;
                    case ADD_DOSSIER:
                        dossier = (Dossier) message.getData();

                        if (SecurityUtils.hasPermission(currentUser, UserRole.ADMIN) &&
                                DOSSIERS_DATABASE.add((Dossier) message.getData())) {
                            String text = dossier.toString() + " - added!";

                            sendMessage(new Message(null, MessageType.TEXT, text), currentUser);
                        } else {
                            String text = "Недостаточно прав доступа для пользователя '"
                                    + currentUser.getName() + "' или дело с заданным ID уже существует..";

                            sendMessage(new Message(null, MessageType.TEXT, text), currentUser);
                        }
                        break;
                    default:
                        String text = "'" + message.getType() + "' - неизвестный тип запроса.";

                        sendMessage(new Message(null, MessageType.TEXT, text), currentUser);
                        ConsoleHelper.writeMessage("Не удалось разобрать запрос пользователя. Попробуйте позже");
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
                ConsoleHelper.writeMessage("Удален пользователь: " + currentUser.toString());
                ConsoleHelper.writeMessage("Сооединение с удаленным сервером закрыто");
            } catch (Exception eE){
                ConsoleHelper.writeMessage("Произошла ошибка при удалении пользователя");
            }
        }
    }
}