package by.epam.learn.multithread.tasks.maintask;

import by.epam.learn.multithread.tasks.maintask.task01.Tunnel;
import by.epam.learn.multithread.tasks.maintask.task01.ship.Ship;
import by.epam.learn.multithread.tasks.maintask.task01.ship.ShipPurpose;

import java.util.concurrent.TimeUnit;

public class Pier implements Runnable{
    private final int id;

    private final Tunnel tunnel;
    private final Port port;

    public Pier(Tunnel tunnel, Port port, int id) {
        this.tunnel = tunnel;
        this.port = port;
        this.id = id;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.currentThread().setName("Pier{" + id + "}");

                TimeUnit.MILLISECONDS.sleep(300);

                Ship ship = tunnel.get();

                if (ship != null){
                     // loading or unloading

                    if (ship.getPurpose() == ShipPurpose.LOADING){
                        loadShip(ship);
                    } else {
                        unloadShip(ship);
                    }
                } else {
                    return;
                }
            } catch (InterruptedException e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    // Loads ship
    private void loadShip(Ship ship) throws InterruptedException {
        System.out.printf("%s start LOAD to %s:\n",
                Thread.currentThread().getName(),
                ship.toString());

        while (ship.countCheck()){
            TimeUnit.MILLISECONDS.sleep(100);
                int count = port.get(10);
                ship.add(count);
                System.out.printf("%d loaded to %s from %s.\n",
                        count, ship.toString(),
                        Thread.currentThread().getName());
        }

        System.out.printf("%s finish load to %s:\n",
                Thread.currentThread().getName(),
                ship.toString());
    }

    // Unloads ship
    private void unloadShip(Ship ship) throws InterruptedException {
        System.out.printf("%s start UNLOAD to %s:\n",
                Thread.currentThread().getName(),
                ship.toString());

        while (ship.countCheck() && port.canTake()){
                TimeUnit.MILLISECONDS.sleep(100);
                int count = ship.get(10);
                port.add(count);
                System.out.printf("%d unloaded from %s to %s.\n",
                        count,
                        Thread.currentThread().getName(),
                        ship.toString());
        }

        System.out.printf("%s finish UNLOAD to %s:\n",
                Thread.currentThread().getName(),
                ship.toString());
    }
}