package javarush.task.task26.task2613.command;

import javarush.task.task26.task2613.CashMachine;
import javarush.task.task26.task2613.ConsoleHelper;
import javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

class LoginCommand implements Command{

    private final ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.verifiedCards");

    @Override
    public void execute() throws InterruptOperationException {
        Locale.setDefault(Locale.ENGLISH);

        while (true){
            ConsoleHelper.writeMessage("Write credit card's number and pin code");
            String number = ConsoleHelper.readString();
            String pin = ConsoleHelper.readString();

            if (!number.matches("\\d{12}") || !pin.matches("\\d{4}")) {
                ConsoleHelper.writeMessage("Wrong credit card's number or pin");
                continue;
            }

            if (validCreditCards.containsKey(number) &&
                    validCreditCards.getString(number).equals(pin)){
                ConsoleHelper.writeMessage("Logging in");

                break;
            }

            ConsoleHelper.writeMessage("Wrong data, try again");
        }
    }
}
