package javarush.task.task27.task2712;

import javarush.task.task27.task2712.kitchen.Cook;
import javarush.task.task27.task2712.kitchen.Order;
import javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager implements Observer {
    private LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public OrderManager() {
                Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (!orderQueue.isEmpty()){
                        for (Cook cook : StatisticManager.getInstance().getCooks()){
                            if (!cook.isBusy()) cook.startCookingOrder(orderQueue.poll());
                        }
                    }
                }
            }
        });
        thread.isDaemon();
        thread.start();
    }

    @Override
    public void update(Observable o, Object arg) {
        orderQueue.add((Order) arg);
    }
}