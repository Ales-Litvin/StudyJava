package javarush.task.task27.task2712;

import javarush.task.task27.task2712.kitchen.Cook;
import javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {
    private final static int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        Cook cook = new Cook("Amigo");
        cook.addObserver(waiter);
        Tablet tablet = new Tablet(5);
        tablet.addObserver(cook);
        tablet.createOrder();
        DirectorTablet director = new DirectorTablet();
        director.printActiveVideoSet();
        director.printAdvertisementProfit();
        director.printArchivedVideoSet();
        director.printCookWorkloading();
    }
}