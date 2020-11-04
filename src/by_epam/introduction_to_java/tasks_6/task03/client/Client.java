package by_epam.introduction_to_java.tasks_6.task03.client;

import by_epam.introduction_to_java.tasks_6.task03.Connection;
import by_epam.introduction_to_java.tasks_6.task03.ConsoleHelper;
import by_epam.introduction_to_java.tasks_6.task03.entity.message.Message;
import by_epam.introduction_to_java.tasks_6.task03.entity.message.MessageType;
import by_epam.introduction_to_java.tasks_6.task03.entity.user.User;


import java.io.IOException;
import java.net.Socket;

public class Client {
    private User currentUser;
    protected Connection connection;
    volatile private boolean clientConnected;

    public Client() {
        this.currentUser = getUser();
    }

    protected User getUser(){
        ConsoleHelper.writeMessage("Введите имя пользователя");
        String userName = ConsoleHelper.readString();

        ConsoleHelper.writeMessage("Введите парль");
        String password = ConsoleHelper.readString();

        return new User(userName, password, null);
    }

    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Введите адрес сервера");
        return ConsoleHelper.readString();
    }

    protected int getServerPort(){
        ConsoleHelper.writeMessage("Введите порт сервера");
        return ConsoleHelper.readInt();
    }

    @Deprecated
    protected String getUserName(){
        ConsoleHelper.writeMessage("Введите имя пользователя");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    // просто отправляет сообщение
    @Deprecated
    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(currentUser, MessageType.TEXT, text));
        } catch(IOException e) {
            ConsoleHelper.writeMessage("Произошла ошибка отправки сообщения!");
            clientConnected = false;
        }
    }

    // Отправляет сообщение с объектом на сервер
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

        // пересмотрерть эту часть добавить обработку комманд
        while (clientConnected){
            String text = ConsoleHelper.readString();
            if (text.equals("exit")) break;
            if (shouldSendTextFromConsole()) sendTextMessage(text);
        }
    }

    public static void main(String[] args) {
        Client client = new Client ();
        client.run();
    }

    // нить соединения
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

        @Deprecated
        protected void informAboutAddingNewUser(String  userName){
            ConsoleHelper.writeMessage(String.format("Участник %s присоединился к чату.", userName));
        }

        @Deprecated
        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(String.format("Участник %s покинул чат.", userName));
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true){
                Message message = connection.receive();
                if (message.getType() == MessageType.USER_REQUEST) {
                    connection.send(new Message(null, MessageType.USER_DATA, getUserName()));
                }
                else if (message.getType() == MessageType.USER_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    return;
                }
                else {
                    throw new IOException("Unexpected MessageType");
                }

            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true){
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                   // processIncomingMessage(message.getData());
                }
                else if (message.getType() == MessageType.USER_ADDED) {
                   // informAboutAddingNewUser(message.getData());
                }
                else if (message.getType() == MessageType.USER_REMOVED) {
                  //  informAboutDeletingNewUser(message.getData());
                }
                else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }
    }
}