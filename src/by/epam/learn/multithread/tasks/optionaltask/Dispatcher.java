package by.epam.learn.multithread.tasks.optionaltask;

import java.util.Objects;

public class Dispatcher implements Runnable{
    private final int id;
    private final Airport airport;


    public Dispatcher(int id, Airport airport) {
        this.id = id;
        this.airport = airport;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.toString());

        Plane plane;
        while ((plane = airport.getPlane()) != null){
            Runway runway = airport.getRunway();
            plane.takeOff(runway);
            airport.clearRunway(runway);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dispatcher)) return false;
        Dispatcher that = (Dispatcher) o;
        return id == that.id &&
                Objects.equals(airport, that.airport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, airport);
    }

    @Override
    public String toString() {
        return "Dispatcher{" + "id=" + id + '}';
    }
}
