package javarush.task.task27.task2712;

import javarush.task.task27.task2712.kitchen.Cook;
import javarush.task.task27.task2712.kitchen.Waiter;
import javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private final static int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) throws InterruptedException {
        Waiter waiter = new Waiter();
        Cook cookOne = new Cook("Amigo");
        Cook cookFirst = new Cook("Domino");

        cookOne.addObserver(waiter);
        cookFirst.addObserver(waiter);

        StatisticManager statisticManager = StatisticManager.getInstance();
        statisticManager.register(cookOne);
        statisticManager.register(cookFirst);

        OrderManager orderManager = new OrderManager();

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            Tablet tablet = new Tablet(i);
        }

        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        thread.start();

        Thread.sleep(1000);
        thread.interrupt();

        DirectorTablet director = new DirectorTablet();
        director.printActiveVideoSet();
        director.printAdvertisementProfit();
        director.printArchivedVideoSet();
        director.printCookWorkloading();
    }
}