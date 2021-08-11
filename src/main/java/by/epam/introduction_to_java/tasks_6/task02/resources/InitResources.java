package by.epam.introduction_to_java.tasks_6.task02.resources;

import by.epam.introduction_to_java.tasks_6.task02.loader.DataLoader;
import by.epam.introduction_to_java.tasks_6.task02.entity.Note;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for helping load data in the file.
 * This class creates for testing.
 */
public class InitResources {

    public static List<Note> notes;

    static {
        notes = new ArrayList<>();
        notes.add(new Note("Sunday", "myEmail@mail.ru", "Go to work."));
        notes.add(new Note("Monday", "myEmail@mail.ru", "Go study."));
        notes.add(new Note("Tuesday", "myEmail@mail.ru", "Go study to cafe'."));
        notes.add(new Note("Wednesday", "myEmail2@mail.ru", "How are you?"));
        notes.add(new Note("Thursday", "myEmail2@mail.ru", ""));
        notes.add(new Note("Friday", "myEmail2@mail.ru", "Yea Friday!"));
        notes.add(new Note("Saturday", "myEmail2@mail.ru", "Saturday is free day!"));
    }


    public static void main(String[] args) {
        DataLoader<Note> userDataLoader = new DataLoader<>(
                "notes.txt"
        );

        userDataLoader.store(notes);
    }
}