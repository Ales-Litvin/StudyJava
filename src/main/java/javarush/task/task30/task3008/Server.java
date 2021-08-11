package javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt());
        ConsoleHelper.writeMessage("Сервер запущен");

        try {
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.run();
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка.");
            serverSocket.close();
        }
    }

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage (Message message){
        for (Map.Entry<String, Connection> pair : connectionMap.entrySet()){
            try {
                pair.getValue().send(message);
            } catch (IOException e){
                System.out.println("Сообщение не доставлено.");
            }
        }
    }

    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST, "Введите имя пользователя ^_^."));
                Message message = connection.receive();
                String userName = message.getData();
                if (message.getType().equals(MessageType.USER_NAME)
                        && !userName.isEmpty()
                        && !connectionMap.containsKey(userName)){
                    connectionMap.put(userName, connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED, "Пользователь зарегистрирован."));
                    return message.getData();
                }
            }
        }

        private void notifyUsers (Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet()){
                if(!pair.getKey().equals(userName)){
                    connection.send(new Message (MessageType.USER_ADDED, pair.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException,  ClassNotFoundException{
            while (true) {
                Message message = connection.receive();
                if (message.getType() == (MessageType.TEXT)){
                    String stringMessage = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message (MessageType.TEXT, stringMessage));
                }
                else {
                    ConsoleHelper.writeMessage("Ошибка приема сообщения.");
                }
            }
        }

        public void run(){
            ConsoleHelper.writeMessage(socket.getRemoteSocketAddress().toString());
            String userName = null;
            try (Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                notifyUsers(connection, userName);
                sendBroadcastMessage(new Message (MessageType.USER_ADDED, userName));
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e){
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с сервером");
            }

            try {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message (MessageType.USER_REMOVED, userName));
                ConsoleHelper.writeMessage("Сооединение с удаленным сервером закрыто");
            } catch (Exception eE){
                ConsoleHelper.writeMessage("Произошла ошибка при удалении пользователя");
            }
        }
    }
}