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

    public static String askCurrencyCode(){
        writeMessage("Write currency's code, please");
        String code = readString();

        if (code.length() == 3){
            return code.toUpperCase();
        } else {
            writeMessage("Incorrect data, try again");
            return askCurrencyCode();
        }
    }

    public static String[] getValidTwoDigits(String currencyCode){
        writeMessage("Write currency's denomination and count separated by a space, please");

        String data = readString().trim();

        if (data.matches("\\d+\\s\\d+")){
            return data.split(" ");
        }  else {
            writeMessage("Incorrect data, try again");
            return getValidTwoDigits(currencyCode);
        }
    }
}
