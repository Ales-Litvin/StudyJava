package by_epam.introduction_to_java.tasks_6.task04;

import by_epam.introduction_to_java.tasks_6.task04.ship.Ship;
import by_epam.introduction_to_java.tasks_6.task04.ship.ShipPurpose;

import java.util.ArrayList;
import java.util.List;

public class Tunnel {

    private List<Ship> store;

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
                String info = String.format("%s + The ship arrived in the tunnel: %s %s %s",
                        store.size(), element.getPurpose(), element.getSize(), Thread.currentThread().getName());
                System.out.println(info);
                shipsCounter++;
            } else {
                System.out.println(store.size() + "> There is no place for a ship in the tunnel: "
                        + Thread.currentThread().getName());
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
                        System.out.println(store.size() +
                                " - The ship is taken from the tunnel: " + Thread.currentThread().getName());
                        store.remove(ship);
                        return ship;
                    }
                }
            }

            System.out.println("0 < There are no ships in the tunnel");
            wait();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
