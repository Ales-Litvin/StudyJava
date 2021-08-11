package by.epam.learn.multithread.tasks.optionaltask;

import java.util.Objects;

public class Runway {
    private final int number;

    public Runway(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Runway)) return false;
        Runway runway = (Runway) o;
        return number == runway.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Runway{" + "number=" + number + '}';
    }
}