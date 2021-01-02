package by.epam.learn.io.tasks.maintask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private ConsoleHelper() { }

    private static final BufferedReader bis =
            new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        try {
            return bis.readLine();
        } catch (IOException e){
            System.out.println("Error entering text! Try again.");
            return readString();
        }
    }

    public static int readInt() {
        try {
            return Integer.parseInt(readString());
        } catch (NumberFormatException e){
            System.out.println("Error entering number! Try again.");
            return readInt();
        }
    }
}
