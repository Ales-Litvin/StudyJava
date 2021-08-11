package by.epam.learn.multithread.tasks.optionaltask;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Plane {
    private final int id;

    public Plane(int id) {
        this.id = id;
    }

    public void takeOff(Runway runway) {
        try {
            if (runway != null) {
                TimeUnit.SECONDS.sleep(1);

                System.out.printf("%s: %s take off from %s!\n",
                        Thread.currentThread().getName(),
                        this.toString(),
                        runway.toString());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        Plane plane = (Plane) o;
        return id == plane.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Plane{" + "id=" + id + '}';
    }
}
