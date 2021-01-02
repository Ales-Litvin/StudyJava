package by.epam.introduction_to_java.tasks_6.task02.utils;

import by.epam.introduction_to_java.tasks_6.task02.entity.Note;
import by.epam.introduction_to_java.tasks_6.task02.exception.IncorrectDataException;

import java.util.List;

/**
 * Describes Data Access Object (DAO)
 */
public interface Dao<T>{

    /**
     * Returns all notes.
     */
    List<T> getAllNotes();

    /**
     * Returns list of notes by the subject.
     */
    List<T> getNotes(String subject) throws IncorrectDataException;

    /**
     * Returns list of notes by the date.
     */
    List<Note> getNotesByDate(String date) throws IncorrectDataException;

    /**
     * Returns list of notes by the subject and date.
     */
    List<Note> getNotesBySubjectAndDate(String subject, String date) throws IncorrectDataException;

    /**
     * Returns list of notes by the email.
     */
    List<T> getNotesByEmail(String email) throws IncorrectDataException;

    /**
     * Returns list of notes by the content.
     */
    List<T> getNotesByContent(String content) throws IncorrectDataException;

    /**
     * Adds the note.
     */
    void add(String subject, String email, String content) throws IncorrectDataException;

    /**
     * Saves notes in the data base.
     */
    void save();

    /**
     * Loads notes from the data base.
     */
    void load();
}
