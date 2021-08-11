package javarush.task.task26.task2613;

import javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {

    private final static ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.common");

    public static void writeMessage(String message){
        System.out.println(message);
    }

    private static final BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static String readString() throws InterruptOperationException {
        String userRequest = null;

        try {
            userRequest = bis.readLine();
            if ("EXIT".equalsIgnoreCase(userRequest)){
                throw new InterruptOperationException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userRequest;
    }

    public static int readInt() throws InterruptOperationException {
        while (true) {
            try {
                return Integer.parseInt(readString());
            } catch (NumberFormatException e) {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        String code = readString();

        if (code.matches("\\w{3}")){
            return code.toUpperCase();
        } else {
            writeMessage(res.getString("invalid.data"));
            return askCurrencyCode();
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage(String.format(
                res.getString("choose.denomination.and.count.format"),
                currencyCode));

        String data = readString().trim();

        if (data.matches("\\d+\\s\\d+")){
            return data.split(" ");
        }  else {
            writeMessage(res.getString("invalid.data"));
            return getValidTwoDigits(currencyCode);
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        while (true) {
            writeMessage(res.getString("choose.operation"));
            writeMessage("1 - " + res.getString("operation.INFO"));
            writeMessage("2 - " + res.getString("operation.DEPOSIT"));
            writeMessage("3 - " + res.getString("operation.WITHDRAW"));
            writeMessage("4 - " + res.getString("operation.EXIT"));
            try {
                return Operation.getAllowableOperationByOrdinal(readInt());
            } catch (IllegalArgumentException e) {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }
}
