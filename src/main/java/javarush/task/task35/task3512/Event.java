package javarush.task.task35.task3512;

public class Event {

    private static int nextID = 1;

    private int id;

    public Event() {
        id = nextID++;
    }

    public int getId() {
        return id;
    }

}
