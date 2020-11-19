package javarush.task.task26.task2613.command;

import javarush.task.task26.task2613.ConsoleHelper;
import javarush.task.task26.task2613.CurrencyManipulator;
import javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.Locale;

class DepositCommand implements Command {

    @Override
    public void execute() {
        String code = ConsoleHelper.askCurrencyCode();
        String[] digits = ConsoleHelper.getValidTwoDigits(code);
        CurrencyManipulator manipulator =
                CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        //DEPOSIT
        manipulator.addAmount(
                Integer.parseInt(digits[0]),
                Integer.parseInt(digits[1]));
    }
}
