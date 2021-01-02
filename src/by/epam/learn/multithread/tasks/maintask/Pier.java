package by.epam.learn.multithread.tasks.maintask;

import by.epam.introduction_to_java.tasks_6.task04.Tunnel;
import by.epam.introduction_to_java.tasks_6.task04.ship.Ship;
import by.epam.introduction_to_java.tasks_6.task04.ship.ShipPurpose;

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

                Thread.sleep(500);

                Ship ship = tunnel.get();

                if (ship != null){
                     // loading or unloading

                    if (ship.getPurpose() == ShipPurpose.LOADING){
                        loadShip(ship);
                    } else {
                        unloadShip(ship);
                    }
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    // Loads ship
    private void loadShip(Ship ship) throws InterruptedException {
        while (ship.countCheck()){
                Thread.sleep(100);
                int count = port.get(10);
                ship.add(count);
                System.out.printf("%d loaded to %s from %s.\n",
                        count, ship.toString(),
                        Thread.currentThread().getName());
        }
    }

    // Unloads ship
    private void unloadShip(Ship ship) throws InterruptedException {
        while (ship.countCheck() && port.canTake()){
                Thread.sleep(100);
                int count = ship.get(10);
                port.add(count);
                System.out.printf("%d unloaded from %s to %s.\n",
                        count, ship.toString(),
                        Thread.currentThread().getName());
        }
    }
}
