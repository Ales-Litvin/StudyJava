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

package by.epam.introduction_to_java.basics_of_OOP_5.task04.view;

import by.epam.introduction_to_java.basics_of_OOP_5.task04.controller.Controller;
import by.epam.introduction_to_java.basics_of_OOP_5.task04.model.Treasure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class View {
    private Controller controller;

    public View(Controller controller) { this.controller = controller; }

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Prints a message to the console
     */
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    /**
     * Returns a string entered from the keyboard
     */
    public static String readString() {
        try {
            return READER.readLine();
        } catch (IOException e){
            System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            return readString();
        }
    }

    /**
     * Prints the list of treasures how table.
     */
    public void printTreasure(List<Treasure> treasures){
        String formatTable =
                " %-" + getLongestName(treasures) + "s | %.2f \n";
        writeMessage(
                "=====================================================\n" +
                "List of treasures:\n" +
                "-----------------------------------------------------");
        for (Treasure treasure : treasures){
            System.out.printf(formatTable, treasure.getName(), treasure.getPrice());
        }
        writeMessage("=====================================================");
        System.out.printf(formatTable, "Total price :", controller.getTotalPrice(treasures));

    }

    /**
     * Prints the list of treasures how table.
     */
    public void printTreasure(Treasure treasure){
        System.out.printf(" %s | %.2f \n", treasure.getName(), treasure.getPrice());
    }

    /**
     * Returns the max length of treasure's name in the list.
     */
    private static int getLongestName(List<Treasure> treasures){
        int max = 0;
        for(Treasure treasure : treasures){
            if (max < treasure.getName().length()){
                max = treasure.getName().length();
            }
        }
        return max;
    }

    /**
     * Prints all actions this program.
     */
    public static void printAllCommand(){
        writeMessage(
                "Choose an action: \n" +
                "-------------------------------------\n" +
                "1 - help\n" +
                "2 - show list of treasures\n" +
                "  2.1 - in order of price\n" +
                "  2.2 - in order of name\n" +
                "3 - get the most expensive treasure\n" +
                "4 - choose treasure by price\n" +
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
                case "2": printTreasure(controller.getTreasures());
                break;
                case "2.1": showTreasuresByPrice();
                break;
                case "2.2": showTreasuresByName();
                break;
                case "3": printTreasure(controller.getTheMostExpensive());
                break;
                case "4": getTreasureForPrice();
                break;
                default : writeMessage("\"" + string + "\"" + " not a command");
                break;
            }
        }
        writeMessage("Bye!");
    }

    /**
     * Shows random treasures for a given price.
     */
    public void getTreasureForPrice(){
        writeMessage("Enter price, please...");

        double price;
        try {
            price = Double.parseDouble(readString());
            if (price <= 0) {
                writeMessage("Wrong data! Try again later.");
            }
        } catch (NumberFormatException ignored){
            writeMessage("Wrong data! Try again later.");
            return;
        }

        List<Treasure> result = controller.getTreasuresForPrice(price);

        if (result.isEmpty()) {
            System.out.printf(
                    "Failed to choose treasures for price %.2f \n", price );
        } else {
            printTreasure(result);
        }
    }

    /**
     * Prints the list of treasures in order by price.
     */
    public void showTreasuresByPrice(){
        controller.sortTreasuresByPrice();
        printTreasure(controller.getTreasures());
    }

    /**
     * Prints the list of treasures in order by name.
     */
    public void showTreasuresByName(){
        controller.sortTreasuresByName();
        printTreasure(controller.getTreasures());
    }
}