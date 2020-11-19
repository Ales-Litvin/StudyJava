package javarush.task.task26.task2613;

import javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    public static void writeMessage(String message){
        System.out.println(message);
    }

    private static final BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static String readString() throws InterruptOperationException {
        String string = null;

        try {
            string = bis.readLine();
            if (string.equalsIgnoreCase("exit")){
                throw new InterruptOperationException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return string;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage("Write currency's code, please");
        String code = readString();

        if (code.length() == 3){
            return code.toUpperCase();
        } else {
            writeMessage("Incorrect data, try again");
            return askCurrencyCode();
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage("Write currency's denomination and count separated by a space, please");

        String data = readString().trim();

        if (data.matches("\\d+\\s\\d+")){
            return data.split(" ");
        }  else {
            writeMessage("Incorrect data, try again");
            return getValidTwoDigits(currencyCode);
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        writeMessage("Write number of operation, please");
        try {
            return Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
        } catch (IllegalArgumentException e){
            writeMessage("Incorrect data, try again");
            return askOperation();
        }
    }
}
