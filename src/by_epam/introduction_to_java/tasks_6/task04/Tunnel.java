package by_epam.introduction_to_java.tasks_6.task04;

import by_epam.introduction_to_java.tasks_6.task04.ship.Ship;
import by_epam.introduction_to_java.tasks_6.task04.ship.ShipPurpose;

import java.util.ArrayList;
import java.util.List;

public class Tunnel {

    private final List<Ship> store;

    private static final int MAX_SHIPS_IN_TUNNEL = 5;
    private static final int MIN_SHIPS_IN_TUNNEL = 0;

    private int shipsCounter = 0;

    public Tunnel() { this.store = new ArrayList<>(); }

    // Adds ship if 'store' not crowded
    public synchronized boolean add(Ship element){

        try {
            if (shipsCounter < MAX_SHIPS_IN_TUNNEL){
                notifyAll();
                store.add(element);

                System.out.printf(
                        "In the tunnel - %d ships. Added: %s. Thread: %s.\n",
                        store.size(), element.toString(), Thread.currentThread().getName());
                shipsCounter++;
            } else {
                System.out.printf(
                       "No free place, in the tunnel - %d ships. Thread: %s.\n",
                        store.size(), Thread.currentThread().getName());
                wait();
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return true;
    }

    // Returns ship if 'store' has it.
    public synchronized Ship get(ShipPurpose purpose){

        try {
            if (shipsCounter > MIN_SHIPS_IN_TUNNEL){
                notifyAll();
                for (Ship ship : store){
                    if (ship.getPurpose() == purpose){
                        shipsCounter--;
                        store.remove(ship);

                        System.out.printf(
                                "In the tunnel - %d ships. The ship %s went to pier. Thread: %s.\n",
                                        store.size(), ship.toString(), Thread.currentThread().getName());
                        return ship;
                    }
                }
            }

            System.out.printf("No ships. In the tunnel - %d ships. Thread: %s.\n",
                    store.size(), Thread.currentThread().getName());
            wait();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Returns 'first in' ship from 'store'.
    public synchronized Ship get(){

        try {
            if (shipsCounter > MIN_SHIPS_IN_TUNNEL){
                notifyAll();
                Ship ship = store.get(0);
                shipsCounter--;
                store.remove(ship);

                System.out.printf(
                        "In the tunnel - %d ships. The ship went to pier. Thread: %s.\n",
                        store.size(), Thread.currentThread().getName());

                return ship;
            }

            System.out.printf("No ships. In the tunnel - %d ships. Thread: %s.\n",
                    store.size(), Thread.currentThread().getName());
            wait();

    } catch (InterruptedException e) {
        e.printStackTrace();
    }

        return null;
    }
}
