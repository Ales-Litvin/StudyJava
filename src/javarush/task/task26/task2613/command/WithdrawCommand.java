package javarush.task.task26.task2613.command;

import javarush.task.task26.task2613.CashMachine;
import javarush.task.task26.task2613.ConsoleHelper;
import javarush.task.task26.task2613.CurrencyManipulator;
import javarush.task.task26.task2613.CurrencyManipulatorFactory;
import javarush.task.task26.task2613.exception.InterruptOperationException;
import javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;

class WithdrawCommand implements Command {

    private final ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.withdraw");

    @Override
    public void execute() throws InterruptOperationException {
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);

        ConsoleHelper.writeMessage(res.getString("before"));
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String string = ConsoleHelper.readString();
            if (!string.matches("\\d+")){
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }

            int count = Integer.parseInt(string);

            if (!manipulator.isAmountAvailable(count)){
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }

            try {
                for (Map.Entry<Integer, Integer> pair :
                        manipulator.withdrawAmount(count).entrySet()) {

                    ConsoleHelper.writeMessage(String.format(
                            res.getString("success.format"),
                            pair.getKey(),
                            pair.getValue()));
                }
            } catch (NotEnoughMoneyException e){
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                continue;
            }

            break;
        }
    }
}
