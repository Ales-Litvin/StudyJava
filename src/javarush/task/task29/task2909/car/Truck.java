package javarush.task.task29.task2909.car;

public class Truck extends Car {
    public Truck(int numberOfPassengers) {
        super(numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        final int MAX_SEDAN_TRUCK = 80;
        return MAX_SEDAN_TRUCK;
    }
}
