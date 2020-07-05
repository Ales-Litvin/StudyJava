package javarush.task.task27.task2712.kitchen;

import javarush.task.task27.task2712.ConsoleHelper;
import javarush.task.task27.task2712.statistic.StatisticManager;
import javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer{
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable observable, Object arg) {
        ConsoleHelper.writeMessage("Start cooking - " +  arg);
        setChanged();
        StatisticManager.getInstance().register(
                new CookedOrderEventDataRow(observable.toString(), name,
                        ((Order) arg).getTotalCookingTime(), ((Order) arg).dishes));
        notifyObservers(arg);
    }

    @Override
    public String toString() { return name; }
}