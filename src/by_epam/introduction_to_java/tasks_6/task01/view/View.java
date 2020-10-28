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

import by_epam.introduction_to_java.basics_of_OOP_5.task05.entity.Product;
import by_epam.introduction_to_java.basics_of_OOP_5.task05.entity.flower.FlowerType;
import by_epam.introduction_to_java.basics_of_OOP_5.task05.entity.pack.PackType;
import by_epam.introduction_to_java.tasks_6.task01.controller.Controller;
import by_epam.introduction_to_java.tasks_6.task01.entity.User;
import by_epam.introduction_to_java.tasks_6.task01.exceptions.UserNotExistsException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class View {
    private Controller controller;

    // здесь просматреть где устанавливается контроллер
    // в task 3513 view creates in the controller

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

    /**
     * Initializations user in the controller.
     */
    public void initUser(){
        try {
            controller.setCurrentUser(userInput());
        } catch (UserNotExistsException e) {
            writeMessage(e.getMessage());
            writeMessage("Try again late.");
        }
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


    public void action(){
        writeMessage("Enters number of action: ");
        printAllCommand();
        String string;
        while (!(string = readString()).equals("0")){
            switch (string){
                case "1": printAllCommand();
                break;
                case "2": writeMessage(Arrays.toString(FlowerType.values()));
                break;
                case "3": writeMessage(Arrays.toString(PackType.values()));
                break;
                case "4":
                    Product product = getProduct();
                    if (product == null) {
                        writeMessage("Product don't created. Try again late.");
                    } else {
                        writeMessage(product.getName());
                    }
                break;
                default :writeMessage("\"" + string + "\"" + " not a command");
                break;
            }
        }
        writeMessage("Bye!");
    }


    public void authorization(){

    }

    /**
     * Returns object Product for givens describe.
     */
    public Product getProduct(){
        writeMessage(
                "Enter the order in the format: <name>\\<amt.>\n" +
                "example: ROSE\\1\n" +
                "         ASTER\\2\n" +
                "         PAPER");

        StringBuilder sb = new StringBuilder();
        String data = null;
        while (!(data = readString()).isEmpty()){
            sb.append(data);
        }

        return null;
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
        return Integer.parseInt(text.trim());
    }
}