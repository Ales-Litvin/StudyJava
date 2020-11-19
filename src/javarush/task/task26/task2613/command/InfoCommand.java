package javarush.task.task26.task2613.command;

import javarush.task.task26.task2613.ConsoleHelper;
import javarush.task.task26.task2613.CurrencyManipulator;
import javarush.task.task26.task2613.CurrencyManipulatorFactory;

class InfoCommand implements Command {

    @Override
    public void execute() {
        if (CurrencyManipulatorFactory.getAllCurrencyManipulators().isEmpty()) {
            ConsoleHelper.writeMessage("No money available.");
        }

        for (CurrencyManipulator manipulator :
                CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
            if (manipulator.hasMoney()) {
                ConsoleHelper.writeMessage(
                        manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
            } else {
                ConsoleHelper.writeMessage("No money available.");
            }
        }
    }
}