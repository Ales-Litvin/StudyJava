package by_epam.introduction_to_java.tasks_6.task02.utils;

import by_epam.introduction_to_java.tasks_6.task01.network.EmailSender;
import by_epam.introduction_to_java.tasks_6.task02.entity.Note;
import by_epam.introduction_to_java.tasks_6.task02.loader.DataLoader;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Implements interface {@link Dao}.
 *
 * @author Aliaksandr Rachko
 * @version 1.0
 */
public class NoteDao implements Dao<Note> {

    private List<Note> notes;

    private DataLoader<Note> loader;

    public NoteDao(DataLoader<Note> loader) {
       this.loader = loader;
       this.notes = new ArrayList<>(loader.load());
    }

    // setters
    public void setLoader(DataLoader<Note> loader) {
        this.loader = loader;
    }

    @Override
    public Set<Note> getNotes(String subject) {
        return null;
    }

    @Override
    public Set<Note> getNotes(Date date) {
        return null;
    }

    @Override
    public Set<Note> getNotes(String subject, Date date) {
        return null;
    }

    @Override
    public Set<Note> getNotesByEmail(String email) {
        return null;
    }

    @Override
    public Set<Note> getNotesByContent(String content) {
        return null;
    }

    /**
     * Adds new {@link Note}.
     */
    @Override
    public void add(String subject, String email, String content) {
        // chek data by null or EMAIL_PATTERN

    }

    /**
     * Pattern for check email.
     */
    public static final Pattern EMAIL_PATTERN = Pattern.compile(".+@.+\\..+");


    /**
     * Saves data use {@link DataLoader}.
     */
    @Override
    public void save() {
        loader.store(notes);
    }

    /**
     * Loads data use {@link DataLoader}.
     */
    @Override
    public void load() {
        notes = new ArrayList<>(loader.load());
    }
}
