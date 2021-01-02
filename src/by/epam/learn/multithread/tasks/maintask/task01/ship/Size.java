package by.epam.learn.multithread.tasks.maintask.task01.ship;

public enum Size {
    SMALL(10),
    MIDDLE(50),
    LARGE(100);

    Size(int value){ this.value = value; }

    private final int value;

    public int getValue() { return value; }
}