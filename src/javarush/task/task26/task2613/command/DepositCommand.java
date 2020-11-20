package javarush.task.task26.task2613.command;

import javarush.task.task26.task2613.CashMachine;
import javarush.task.task26.task2613.ConsoleHelper;
import javarush.task.task26.task2613.CurrencyManipulator;
import javarush.task.task26.task2613.CurrencyManipulatorFactory;
import javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

class DepositCommand implements Command {

    private final ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.deposit_en");

    @Override
    public void execute() throws InterruptOperationException {
        Locale.setDefault(Locale.ENGLISH);

        ConsoleHelper.writeMessage(res.getString("before"));
        String code = ConsoleHelper.askCurrencyCode();
        String[] digits = ConsoleHelper.getValidTwoDigits(code);
        //DEPOSIT
        int denomination = Integer.parseInt(digits[0]);
        int count = Integer.parseInt(digits[1]);
        if (denomination > 0 && count > 0){
            CurrencyManipulator manipulator =
                    CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
            manipulator.addAmount(denomination , count);
            ConsoleHelper.writeMessage(String.format(
                    res.getString("success.format"),
                    denomination * count,
                    code));
        } else {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
    }
}
