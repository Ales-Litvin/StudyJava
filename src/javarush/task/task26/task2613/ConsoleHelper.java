package javarush.task.task26.task2613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    public static void writeMessage(String message){
        System.out.println(message);
    }

    private static final BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static String readString(){
        String string = null;

        try {
            string = bis.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return string;
    }
}
