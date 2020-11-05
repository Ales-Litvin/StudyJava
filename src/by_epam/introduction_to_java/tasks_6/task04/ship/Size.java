package by_epam.introduction_to_java.tasks_6.task04.ship;

public enum Size {
    SMALL(10),
    MIDDLE(50),
    LARGE(100);

    Size(int value){ this.value = value; }

    private final int value;

    public int getValue() { return value; }
}