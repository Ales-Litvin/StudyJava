package javarush.task.task26.task2613;

import javarush.task.task26.task2613.command.CommandExecutor;
import javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Operation operation = null;

        try {
            do {

                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);

            } while (operation != Operation.EXIT);
        } catch (InterruptOperationException e) {
            ConsoleHelper.writeMessage("Bye!");
        }
    }
}
