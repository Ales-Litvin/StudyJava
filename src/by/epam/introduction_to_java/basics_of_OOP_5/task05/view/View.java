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

package by.epam.introduction_to_java.basics_of_OOP_5.task05.view;

import by.epam.introduction_to_java.basics_of_OOP_5.task05.controller.Controller;
import by.epam.introduction_to_java.basics_of_OOP_5.task05.entity.Product;
import by.epam.introduction_to_java.basics_of_OOP_5.task05.entity.flower.FlowerType;
import by.epam.introduction_to_java.basics_of_OOP_5.task05.entity.flower.Flower;
import by.epam.introduction_to_java.basics_of_OOP_5.task05.entity.pack.PackType;

import java.util.Arrays;

public class View {
    private Controller controller;

    public View(Controller controller) { this.controller = controller; }

    /**
     * Prints the list of products.
     */
    public void printProducts(Flower[] products){
        ConsoleHelper.writeMessage(
                "====================================\n" +
                        "List of available products :\n" +
                        "------------------------------------");
        for (Flower product : products){
            System.out.printf(" %-10s | %.2f \n", product.getName(), product.getPrice());
        }
    }

    /**
     * Prints the list of product.
     */
    public void printProduct(Flower product){
        System.out.printf(" %s | %.2f \n", product.getName(), product.getPrice());
    }

    /**
     * Prints all actions this program.
     */
    public static void printAllCommand(){
        ConsoleHelper.writeMessage(
                "Choose an action: \n" +
                        "-------------------------------------\n" +
                        "1 - help\n" +
                        "2 - show list of flowers\n" +
                        "3 - show list of pack\n" +
                        "4 - choose flower composition\n" +
                        "0 - exit\n" +
                        "-------------------------------------");
    }


    public void action(){
        ConsoleHelper.writeMessage("Enters number of action: ");
        printAllCommand();
        String string;
        while (!(string = ConsoleHelper.readString()).equals("0")){
            switch (string){
                case "1": printAllCommand();
                    break;
                case "2": ConsoleHelper.writeMessage(Arrays.toString(FlowerType.values()));
                    break;
                case "3": ConsoleHelper.writeMessage(Arrays.toString(PackType.values()));
                    break;
                case "4":
                    Product product = getProduct();
                    if (product == null) {
                        ConsoleHelper.writeMessage("Product don't created. Try again late.");
                    } else {
                        ConsoleHelper.writeMessage(product.getName());
                    }
                    break;
                default : ConsoleHelper.writeMessage("\"" + string + "\"" + " not a command");
                    break;
            }
        }
        ConsoleHelper.writeMessage("Bye!");
    }

    /**
     * Returns object Product for givens describe.
     */
    public Product getProduct(){
        ConsoleHelper.writeMessage(
                "Enter the order in the format: <name>\\<amt.>\n" +
                        "example: ROSE\\1\n" +
                        "         ASTER\\2\n" +
                        "         PAPER");

        StringBuilder sb = new StringBuilder();
        String data = null;
        while (!(data = ConsoleHelper.readString()).isEmpty()){
            sb.append(data);
        }

        return controller.getProduct(sb.toString());
    }

}