package by.epam.learn.multithread.tasks.maintask.task01;

import by.epam.learn.multithread.tasks.maintask.task01.ship.Ship;
import by.epam.learn.multithread.tasks.maintask.task01.ship.ShipPurpose;
import by.epam.learn.multithread.tasks.maintask.task01.ship.Size;

import java.util.Random;

// This is ship's generator
public class ShipGenerator implements Runnable{
    private final Tunnel tunnel;

    private final int shipCount;

    public ShipGenerator(Tunnel tunnel, int shipCount) {
        this.tunnel = tunnel;
        this.shipCount = shipCount;
    }

    // Creates ship and adds it to tunnel if it ready.
    @Override
    public void run() {
        int count = 0;
        while (count < shipCount){
            Thread.currentThread().setName("Generator ship");
            count++;
            tunnel.add(new Ship(getRandomSize(), getRandomPurpose()));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private ShipPurpose getRandomPurpose(){
        Random random = new Random();
        return ShipPurpose.values()[
                random.nextInt(ShipPurpose.values().length)];
    }

    private Size getRandomSize() {
        Random random = new Random();
        return Size.values()[random.nextInt(Size.values().length)];
    }
}