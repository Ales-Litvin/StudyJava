package by.epam.learn.multithread.tasks.optionaltask;

import java.util.concurrent.ArrayBlockingQueue;

public class Airport {
    private final Dispatcher[] dispatchers;
    private static final int AMOUNT_OF_DISPATCHERS = 2;

    private final ArrayBlockingQueue<Runway> freeRunways;
    private static final int AMOUNT_OF_RUNWAYS = 5;

    private final ArrayBlockingQueue<Plane> planes;

    public Airport() {
        this.freeRunways = new ArrayBlockingQueue<>(AMOUNT_OF_RUNWAYS);
        initRunways();
        this.dispatchers = new Dispatcher[AMOUNT_OF_DISPATCHERS];
        initPlane();
        this.planes = new ArrayBlockingQueue<>(10);
    }

    private void initRunways() {
        for (int i = 0; i < AMOUNT_OF_RUNWAYS; i++) {
            try {
                freeRunways.put(new Runway(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    private void initPlane() {
        for (int i = 0; i < AMOUNT_OF_DISPATCHERS; i++) {
            dispatchers[i] = new Dispatcher(i, this);
        }
    }

    public boolean addPlane(Plane plane) {

        return planes.offer(plane);
    }

    public Plane getPlane() {
        return planes.poll();
    }

    public boolean clearRunway(Runway runway) {
        System.out.printf("%s: %s is free.\n",
                Thread.currentThread().getName(),
                runway.toString());
        return freeRunways.offer(runway);
    }

    public Runway getRunway() {
        Runway runway = freeRunways.poll();
        if (runway != null) {
            System.out.printf("%s: %s is free.\n",
                    Thread.currentThread().getName(),
                    runway.toString());
        }
        return runway;
    }

    public ArrayBlockingQueue<Plane> getPlanes() {
        return planes;
    }

    public Dispatcher[] getDispatchers() {
        return dispatchers;
    }
}
