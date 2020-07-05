package javarush.task.task27.task2712;

import javarush.task.task27.task2712.ad.AdvertisementManager;
import javarush.task.task27.task2712.ad.NoVideoAvailableException;
import javarush.task.task27.task2712.kitchen.Order;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private final int number;
    public static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) { this.number = number; }

    public Order createOrder(){
        Order order = null;
        try {
            order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            if (!order.isEmpty()) {
                setChanged();
                notifyObservers(order);
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