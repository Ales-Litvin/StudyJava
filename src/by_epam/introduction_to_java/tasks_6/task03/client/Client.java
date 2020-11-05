package by_epam.introduction_to_java.tasks_6.task03.client;

import by_epam.introduction_to_java.tasks_6.task03.Connection;
import by_epam.introduction_to_java.tasks_6.task03.ConsoleHelper;
import by_epam.introduction_to_java.tasks_6.task03.entity.Dossier;
import by_epam.introduction_to_java.tasks_6.task03.entity.message.Message;
import by_epam.introduction_to_java.tasks_6.task03.entity.message.MessageType;
import by_epam.introduction_to_java.tasks_6.task03.entity.user.User;


import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Client client = new Client ();
        client.run();
    }

    private final User currentUser;
    protected Connection connection;
    volatile private boolean clientConnected;

    public Client() { this.currentUser = getUser(); }

    protected User getUser(){
        ConsoleHelper.writeMessage("Введите имя пользователя");
        String userName = ConsoleHelper.readString().trim();

        ConsoleHelper.writeMessage("Введите пароль");
        String password = ConsoleHelper.readString().trim();

        return new User(userName, password, null);
    }

    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Введите IP-адрес сервера");
        return ConsoleHelper.readString();
    }

    protected int getServerPort(){
        ConsoleHelper.writeMessage("Введите порт сервера");
        return ConsoleHelper.readInt();
    }

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendObjectMessage(MessageType type, Object data){
        try {
            connection.send(new Message(currentUser, type, data));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Произошла ошибка отправки сообщения!");
            clientConnected = false;
        }
    }

    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try {
            synchronized (this){
                wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Ошибка соединения.");
            return;
        }

        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }

        try {
            action();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Main client's loop. Sends request to server.
     * @throws IOException
     */
    public void action() throws IOException {
        printHelp();
        while (clientConnected){
            String text = ConsoleHelper.readString().trim();
            if (text.equals("exit")) break;

            switch (text){
                case "help": printHelp();
                    break;
                case "get":
                    ConsoleHelper.writeMessage("Write the dossier's ID number");
                    long id = (long) ConsoleHelper.readInt();
                    connection.send(new Message(currentUser, MessageType.GET_DOSSIER, id));
                    break;
                case "change":
                    ConsoleHelper.writeMessage("Write new data for dossier. ID doesn't change.");
                    connection.send(new Message(currentUser, MessageType.CHANGE_DOSSIER, getDosser()));
                    break;
                case "add":
                    connection.send(new Message(currentUser, MessageType.ADD_DOSSIER, getDosser()));
                    break;
                default:
                    ConsoleHelper.writeMessage('\'' + text + "' it's not command!");
                    break;
            }
        }
    }

    /**
     * Prints all command.
     */
    public void printHelp(){
        ConsoleHelper.writeMessage(
                "================================\n" +
                "help   | get all commands\n" +
                "get    | get dossier by ID\n" +
                "change | change dossier\n" +
                "add    | add dossier\n" +
                "exit   | exit\n" +
                "================================\n");
    }

    /**
     * Returns new Dossier.
     */
    public Dossier getDosser(){
        ConsoleHelper.writeMessage("Write the dossier's ID number");
        long id = (long) ConsoleHelper.readInt();

        ConsoleHelper.writeMessage("Write firstname");
        String firstName = ConsoleHelper.readString();

        ConsoleHelper.writeMessage("Write surname");
        String surName = ConsoleHelper.readString();

        ConsoleHelper.writeMessage("Write the dossier's content");
        String content = ConsoleHelper.readString();

        return new Dossier(firstName, surName, content, id);
    }


    /**
     * The Thread for to process incoming messages from the server.
     */
    public class SocketThread extends Thread {

        public void run(){
            try {
                Socket  socket = new Socket(getServerAddress(), getServerPort());
                Client.this.connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
                e.printStackTrace();
            }
        }

        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        /**
         * Notifies connection status changed.
         */
        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }

        /**
         * Sends userName and password to server for authorization on server's request.
         * @throws IOException
         * @throws ClassNotFoundException
         */
        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true){
                Message message = connection.receive();

                if (message.getType() == MessageType.USER_REQUEST) {
                    connection.send(new Message(currentUser, MessageType.USER_DATA, null));
                } else if (message.getType() == MessageType.USER_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    ConsoleHelper.writeMessage((String) message.getData());
                    return;
                } else {
                    throw new IOException("Unexpected MessageType: " + message.getType());
                }
            }
        }

        /**
         * The main loop for to process incoming messages from the server.
         */
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true){
                Message message = connection.receive();

                switch (message.getType()){
                    case DOSSIER:
                        Dossier dossier = (Dossier) message.getData();

                        ConsoleHelper.writeMessage(dossier.toString());
                    break;
                    case TEXT:
                    case USER_ACCEPTED:
                        ConsoleHelper.writeMessage((String) message.getData());
                        break;
                    default:
                        throw new IOException("Unexpected MessageType: " + message.getType());
                }
            }
        }
    }
}