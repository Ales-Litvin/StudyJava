package javarush.task.task27.task2712.kitchen;

import javarush.task.task27.task2712.ConsoleHelper;
import javarush.task.task27.task2712.statistic.StatisticManager;
import javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;

public class Cook extends Observable{
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    public void startCookingOrder(Order order){
        ConsoleHelper.writeMessage("Start cooking - " +  order);
        setChanged();
        StatisticManager.getInstance().register(
                new CookedOrderEventDataRow(order.getTablet().toString(), name,
                        order.getTotalCookingTime(),  order.dishes));
        notifyObservers(order);
    }

    @Override
    public String toString() { return name; }
}