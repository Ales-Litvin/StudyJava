package by_epam.introduction_to_java.basics_of_OOP_5.task04.view;

import by_epam.introduction_to_java.basics_of_OOP_5.task04.controller.Controller;
import by_epam.introduction_to_java.basics_of_OOP_5.task04.model.Treasure;


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
    public void printTreasures(List<Treasure> treasures){
        String formatTable =
                " %-" + getLongestName(treasures) + "s | %.2f \n";
        writeMessage(
                "=====================================================" +
                "List of treasures:" +
                "-----------------------------------------------------");
        for (Treasure treasure : treasures){
            System.out.printf(formatTable, treasure.getName(), treasure.getPrice());
        }
        writeMessage("=====================================================");
        System.out.printf(formatTable, "Total price :", controller.getTotalPrice(treasures));

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
                "3 - get the most expensive treasure\n" +
                "4 - choose treasure by price\n" +
                "0 - exit" +
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
                case "2": printTreasures(controller.getTreasures());
                break;
                case "3":
            }


        }

    }

}
