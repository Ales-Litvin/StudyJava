package by_epam.introduction_to_java.tasks_6.task02.utils;

import java.util.Date;
import java.util.Set;

/**
 * Describes Data Access Object (DAO)
 */
public interface Dao<T>{

    /**
     * Returns set of notes by the subject.
     */
    Set<T> getNotes(String subject);

    /**
     * Returns set of notes by the subject.
     */
    Set<T> getNotes(Date date);

    /**
     * Returns set of notes by the subject and the date.
     */
    Set<T> getNotes(String subject, Date date);

    /**
     * Returns set of notes by the email.
     */
    Set<T> getNotesByEmail(String email);

    /**
     * Returns set of notes by the content.
     */
    Set<T> getNotesByContent(String content);

    /**
     * Adds the note.
     */
    void add(String subject, String email, String content);

    /**
     * Saves notes in the data base.
     */
    void save();

    /**
     * Loads notes from the data base.
     */
    void load();
}
