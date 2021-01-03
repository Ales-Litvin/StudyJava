package by.epam.learn.multithread.tasks.maintask.task01;

import by.epam.learn.multithread.tasks.maintask.task01.ship.Ship;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

// It's resource of ships
public class Tunnel {

    private final ArrayBlockingQueue<Ship> store;

    private static final int MAX_SHIPS_IN_TUNNEL = 5;

    public Tunnel() {
        this.store = new ArrayBlockingQueue<>(MAX_SHIPS_IN_TUNNEL);
    }

    // Adds ship if 'store' not crowded
    public boolean add(Ship element) {
        boolean isAdd = false;

        try {
            isAdd = store.offer(element, 2, TimeUnit.SECONDS);

            System.out.printf(
                    "%s: tunnel - %d; added: %s.\n",
                    Thread.currentThread().getName(),
                    store.size(), element.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        return isAdd;
    }

    // Returns ship if 'store' has it.
    public Ship get() {
        Ship ship = store.poll(); // choose needing method

        System.out.printf(
                "%s: tunnel - %d; took: %s.\n",
                Thread.currentThread().getName(),
                store.size(), ship != null ? ship.toString() : "null");

        return ship;
    }

    // Prints information
    public String getInfo() {
        return Thread.currentThread().getName().toUpperCase() +
                "\nSTORE: " + store.toString() + "\n";
    }
}
