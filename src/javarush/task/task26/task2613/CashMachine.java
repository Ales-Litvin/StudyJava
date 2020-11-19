package javarush.task.task26.task2613;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        String code = ConsoleHelper.askCurrencyCode();

        String[] digits = ConsoleHelper.getValidTwoDigits(code);


        CurrencyManipulator manipulator =
                CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);

        manipulator.addAmount(
                Integer.parseInt(digits[0]),
                Integer.parseInt(digits[1]));

        ConsoleHelper.writeMessage(String.valueOf(manipulator.getTotalAmount()));
    }
}
