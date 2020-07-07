package javarush.task.task27.task2712;

import javarush.task.task27.task2712.ad.AdvertisementManager;
import javarush.task.task27.task2712.ad.NoVideoAvailableException;
import javarush.task.task27.task2712.kitchen.Order;
import javarush.task.task27.task2712.kitchen.TestOrder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    private final int number;
    public static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) { this.number = number; }

    private LinkedBlockingQueue<Order> queue;

    public void setQueue(LinkedBlockingQueue<Order> queue) { this.queue = queue; }

    public Order createOrder(){
        Order order = new Order(this);
        return getOrder(order);
    }

    public void createTestOrder(){
        TestOrder order = new TestOrder(this);
        getOrder(order);
    }

    private Order getOrder(Order order) {
        try {
            ConsoleHelper.writeMessage(order.toString());
            if (!order.isEmpty()) {
                queue.add(order);
                new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
            }
        } catch (NoVideoAvailableException exception){
            logger.log(Level.INFO, "No video is available for the order " + order);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } finally {
            return order;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tablet{");
        sb.append("number=").append(number);
        sb.append('}');
        return sb.toString();
    }
}