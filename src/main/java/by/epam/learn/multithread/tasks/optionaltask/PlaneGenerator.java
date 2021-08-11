package by.epam.learn.multithread.tasks.optionaltask;

public class PlaneGenerator implements Runnable {
    private int countPlane;

    private final Airport airport;

    public PlaneGenerator(Airport airport, int countPlane) {
        this.airport = airport;
        this.countPlane = countPlane;
    }

    @Override
    public void run() {
        while (countPlane > 0) {
            Plane newPlane = create(countPlane);
            airport.addPlane(newPlane);
            System.out.printf("%s: %s created!\n",
                    Thread.currentThread().getName(),
                    newPlane.toString());
            countPlane--;
        }
    }

    private Plane create(int id) {
        return new Plane(id);
    }
}