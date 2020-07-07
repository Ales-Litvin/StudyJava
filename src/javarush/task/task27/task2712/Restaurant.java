package javarush.task.task27.task2712;

import javarush.task.task27.task2712.kitchen.Cook;
import javarush.task.task27.task2712.kitchen.Order;
import javarush.task.task27.task2712.kitchen.Waiter;
import javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private final static int ORDER_CREATING_INTERVAL = 100;
    private final static LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        Waiter waiter = new Waiter();
        Cook cookOne = new Cook("Amigo");
        cookOne.setQueue(orderQueue);
        Thread threadOne = new Thread(cookOne);

        Cook cookFirst = new Cook("Domino");
        cookFirst.setQueue(orderQueue);
        Thread threadFirst = new Thread(cookFirst);

        threadOne.start();
        threadFirst.start();

        cookOne.addObserver(waiter);
        cookFirst.addObserver(waiter);

        StatisticManager statisticManager = StatisticManager.getInstance();

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            Tablet tablet = new Tablet(i);
            tablet.setQueue(orderQueue);
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