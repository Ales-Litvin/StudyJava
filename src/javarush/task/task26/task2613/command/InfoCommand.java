package javarush.task.task26.task2613.command;

import javarush.task.task26.task2613.CashMachine;
import javarush.task.task26.task2613.ConsoleHelper;
import javarush.task.task26.task2613.CurrencyManipulator;
import javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

class InfoCommand implements Command {

    private final ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.info_en");


    @Override
    public void execute() {
        if (CurrencyManipulatorFactory.getAllCurrencyManipulators().isEmpty()) {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }

        ConsoleHelper.writeMessage(res.getString("before"));
        for (CurrencyManipulator manipulator :
                CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
            if (manipulator.hasMoney()) {
                ConsoleHelper.writeMessage(
                        manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
            } else {
                ConsoleHelper.writeMessage(res.getString("no.money"));
            }
        }
    }
}