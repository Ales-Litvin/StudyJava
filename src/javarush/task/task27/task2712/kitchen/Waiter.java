package javarush.task.task27.task2712.kitchen;

import javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Waiter implements Observer {
    @Override
    public void update(Observable observable, Object arg) {
        ConsoleHelper.writeMessage(arg + " was cooked by " +
                "" + observable);
    }
}