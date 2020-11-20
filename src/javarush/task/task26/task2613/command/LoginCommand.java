package javarush.task.task26.task2613.command;

import javarush.task.task26.task2613.CashMachine;
import javarush.task.task26.task2613.ConsoleHelper;
import javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

class LoginCommand implements Command{

    private final ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.verifiedCards");

    private final ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.login");

    @Override
    public void execute() throws InterruptOperationException {
        Locale.setDefault(Locale.ENGLISH);
        ConsoleHelper.writeMessage(res.getString("before"));

        while (true){
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String number = ConsoleHelper.readString();
            String pin = ConsoleHelper.readString();

            if (!number.matches("\\d{12}") || !pin.matches("\\d{4}")) {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }

            if (validCreditCards.containsKey(number) &&
                    validCreditCards.getString(number).equals(pin)){
                ConsoleHelper.writeMessage(String.format(
                        res.getString("success.format"),
                        number
                ));

                break;
            }

            ConsoleHelper.writeMessage(String.format(
                    res.getString("not.verified.format"),
                    number));

            ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
        }
    }
}
