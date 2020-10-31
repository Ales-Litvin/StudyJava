/*
 * Copyright (c) 2020, Rachko and/or its affiliates. All rights reserved.
 * RACHKO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package by_epam.introduction_to_java.tasks_6.task01.view;

import by_epam.introduction_to_java.tasks_6.task01.controller.Controller;
import by_epam.introduction_to_java.tasks_6.task01.entity.book.Book;
import by_epam.introduction_to_java.tasks_6.task01.entity.book.TypeBook;
import by_epam.introduction_to_java.tasks_6.task01.entity.user.User;
import by_epam.introduction_to_java.tasks_6.task01.exceptions.BookNotExistsException;
import by_epam.introduction_to_java.tasks_6.task01.exceptions.UserHasNotPermission;
import by_epam.introduction_to_java.tasks_6.task01.exceptions.UserNotExistsException;

import javax.mail.MessagingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class View {
    private final Controller controller;

    public View(Controller controller) { this.controller = controller; }

    /**
     * Prints all actions this program.
     */
    public void printAllCommand(){
        writeMessage(
                "Choose an action: \n" +
                "-------------------------------------\n" +
                "1 - help\n" +
                "2 - change user\n" +
                "3 - look books\n" +
                "4 - search book\n" +
                "5 - offer a book (offer will send to admin ot e-mail)\n" +
                "6 - add book (only for admin)\n" +
                "0 - exit\n" +
                "-------------------------------------");
    }

    public void action(){
        writeMessage("Enters number of action: ");
        printAllCommand();
        String string;
        while (!(string = readString()).equals("0")){
            switch (string){
                case "1": printAllCommand();
                    break;
                case "2": initUser();
                    break;
                case "3": lookBooks(1);
                    break;
                case "4": findBook();
                    break;
                case "5": offerBook();
                    break;
                case "6": addBook();
                    break;
                default :writeMessage("\"" + string + "\"" + " not a command");
                    break;
            }
        }
        writeMessage("Bye!");
    }

    /**
     * Initializations user in the controller.
     */
    public void initUser(){
        try {
            controller.setCurrentUser(userInput());
        } catch (UserNotExistsException e) {
            writeMessage(e.getMessage());
            writeMessage("Try again late.");
            return;
        }
        writeMessage("Logged in!");
    }

    /**
     * Returns object User with input user data.
     */
    public User userInput(){
        writeMessage("Inputs the user name and press 'enter'...");
        String username = readString();

        writeMessage("Inputs the password and press 'enter'...");
        String password = readString();

        return new User(username, password, null, null);
    }

    /**
     * Prints list of books.
     */
    private void printPage(List<Book> books) throws NumberFormatException{
        if (books == null) throw new NullPointerException();
        writeMessage(
                "======================================\n" +
                "Books catalog:\n" +
                "--------------------------------------");
        for (Book book : books){
            writeMessage(
                    String.format("%30s | %5s |", book.getName(), book.getType()));
        }
        writeMessage(
                "--------------------------------------");
    }

    /**
     * Looking catalog by pages.
     */
    public void lookBooks(int numberPage){
        try {
            printPage(controller.getPage(numberPage));
        } catch (UserHasNotPermission | NullPointerException e ) {
            writeMessage(e.getMessage());
            return;
        }
        writeMessage(
                String.format("Page %d of %d", numberPage, controller.getCountPages()));
        writeMessage(
                "======================================");

        writeMessage("Inputs the number of page and press 'enter', or '0' so exit.");

        int page = 0;

        while ((page = readInt()) != 0){
            lookBooks(page);
        }
    }

    /**
     * Finds a book.
     */
    public void findBook(){
        writeMessage("Inputs the name of book and press 'enter'....");
        try {
            writeMessage("The " + controller.getBook(readString()).toString() + " are available.");
        } catch (BookNotExistsException | UserHasNotPermission e) {
            writeMessage(e.getMessage());
        }
    }

    /**
     * Offer user's book.
     */
    public void offerBook(){
        Book book = getBook();
        if (book == null) {
            writeMessage("Wrong data. Try again late.");
            return;
        }

        try {
            controller.offerBook(book);
        } catch (UserHasNotPermission | MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds administrator's book.
     */
    public void addBook(){
        Book book = getBook();
        if (book == null) {
            writeMessage("Wrong data. Try again late.");
            return;
        }

        try {
            controller.addBook(book);
            writeMessage("The " + book.toString() + " are available.");
        } catch (UserHasNotPermission | MessagingException e) {
           e.printStackTrace();
        }
        writeMessage("Was send ");
    }

    /**
     * Returns book given user.
     */
    public Book getBook(){
        writeMessage("Inputs the name of book and press 'enter'....");
        String name = readString();

        if (name == null || name.isEmpty()){
            writeMessage("Name of book not be empty. Try again late.");
            return null;
        }

        writeMessage("Choose type of book:\n" +
                "1 - paper; 2 - e-book\n" +
                "press 'enter'...");

        TypeBook typeBook;
        int type = readInt();
        if (type == 1){
            typeBook = TypeBook.PAPER;
        } else if (type == 2){
            typeBook = TypeBook.E_BOOK;
        } else {
            writeMessage("Don't correct give type of book.");
            return null;
        }
        return new Book(name, typeBook);
    }

    /**
     * Returns array with email address and password.
     */
    public String[] getEmailData(){
        writeMessage("Inputs your email address (xxxx@gmail.com) and press 'enter'....");
        String address = readString().trim();

        writeMessage("Inputs your password for email address: '" + address + "' and press 'enter'....");
        String password = readString().trim();
        return new String[]{address, password};
    }

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Writes message to console.
     */
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    /**
     * Reads message with console.
     */
    public static String readString() {
        String text = null;
        try {
            text = READER.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    /**
     * Reads number with console.
     */
    public static int readInt() {
        String text = readString();
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException e){
            writeMessage("The '" + text + "' is not number. Try again late.");
            return 0;
        }
    }
}