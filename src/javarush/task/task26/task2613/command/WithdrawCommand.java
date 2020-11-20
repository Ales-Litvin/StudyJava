package javarush.task.task26.task2613.command;

import javarush.task.task26.task2613.ConsoleHelper;
import javarush.task.task26.task2613.CurrencyManipulator;
import javarush.task.task26.task2613.CurrencyManipulatorFactory;
import javarush.task.task26.task2613.exception.InterruptOperationException;
import javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Map;

class WithdrawCommand implements Command {

    @Override
    public void execute() throws InterruptOperationException {
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);

        while (true) {
            ConsoleHelper.writeMessage("Write count for withdraw, please.");
            String string = ConsoleHelper.readString();
            if (!string.matches("\\d+")){
                ConsoleHelper.writeMessage("Wrong data, try again.");
                continue;
            }

            int count = Integer.parseInt(string);

            if (!manipulator.isAmountAvailable(count)){
                ConsoleHelper.writeMessage("Insufficient funds.");
                continue;
            }

            try {
                for (Map.Entry<Integer, Integer> pair :
                        manipulator.withdrawAmount(count).entrySet()) {

                    StringBuilder sb = new StringBuilder("\t");
                    sb.append(pair.getKey()).append(" - ").append(pair.getValue());

                    ConsoleHelper.writeMessage(sb.toString());
                }

                ConsoleHelper.writeMessage("Withdraw did.");
            } catch (NotEnoughMoneyException e){
                ConsoleHelper.writeMessage("Insufficient funds.");
                continue;
            }

            break;
        }
    }
}
