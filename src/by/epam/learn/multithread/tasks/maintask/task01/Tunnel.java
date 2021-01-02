package by.epam.learn.multithread.tasks.maintask.task01;

import by.epam.learn.multithread.tasks.maintask.task01.ship.Ship;

import java.util.concurrent.ArrayBlockingQueue;

// It's resource of ships
public class Tunnel {

    private final ArrayBlockingQueue<Ship> store;

    private static final int MAX_SHIPS_IN_TUNNEL = 10;

    public Tunnel() {
        this.store = new ArrayBlockingQueue<Ship>(MAX_SHIPS_IN_TUNNEL);
    }

    // Adds ship if 'store' not crowded
    public void add(Ship element){
            try {
                store.put(element); // choose needing method

                System.out.printf(
                        "In the tunnel - %d ships. Added: %s. Thread: %s.\n",
                        store.size(), element.toString(),
                        Thread.currentThread().getName());
            } catch (InterruptedException e){
                e.printStackTrace();
        }
    }

    // Returns ship if 'store' has it.
    public Ship get(){
        try {
            Ship ship = store.take(); // choose needing method

            System.out.printf(
                    "In the tunnel - %d ships. " +
                            "The ship %s take from tunnel. Thread: %s.\n",
                    store.size(), ship.toString(),
                    Thread.currentThread().getName());
            return ship;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Prints information
    public String printInfo(){
        StringBuilder sb = new StringBuilder("");
        sb.append("\n\n\n");
        sb.append(Thread.currentThread().getName().toUpperCase());
        sb.append("\nSTORE: ").append(store);
        sb.append("\n");
        return sb.toString();
    }
}
