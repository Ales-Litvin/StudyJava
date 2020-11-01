package by_epam.introduction_to_java.tasks_6.task02.utils;

import by_epam.introduction_to_java.tasks_6.task02.entity.Note;
import by_epam.introduction_to_java.tasks_6.task02.exception.IncorrectDataException;
import by_epam.introduction_to_java.tasks_6.task02.loader.DataLoader;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Implements interface {@link Dao}.
 *
 * @see Dao
 * @see DataLoader
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

    /**
     * Returns list containing the all elements in the data base.
     */
    @Override
    public List<Note> getAllNotes() {
        List<Note> result = new ArrayList<>();

        result.addAll(notes);

        Collections.sort(result);
        return result;
    }

    /**
     * Returns list containing the all elements by {@code subject}
     * in the data base.
     * @throws IncorrectDataException if the string equals {@code null} or
     * is empty.
     */
    @Override
    public List<Note> getNotes(String subject) throws IncorrectDataException {
        List<Note> result = new ArrayList<>();

        checkString(subject);

        for (Note note : notes){
            if (subject.equals(note.getSubject())){
                result.add(note);
            }
        }

        Collections.sort(result);
        return result;
    }

    /**
     * Returns list containing the all elements by date
     * (year-month-day).
     * @throws IncorrectDataException if the string equals {@code null} or
     * is empty.
     * @throws DateTimeParseException
     */
    @Override
    public List<Note> getNotesByDate(String date) throws IncorrectDataException, DateTimeParseException {
        List<Note> result = new ArrayList<>();

        checkString(date);

        LocalDate localDate = LocalDate.parse(date.trim());

        for (Note note : notes){
            LocalDate date1 = note.getDate().
                    toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if (localDate.equals(date1)){
                result.add(note);
            }
        }

        Collections.sort(result);
        return result;
    }

    /**
     * Returns list containing the all elements by subject and
     * date (year-month-day).
     * @throws IncorrectDataException if the string equals {@code null} or
     * is empty.
     * @throws DateTimeParseException
     */
    @Override
    public List<Note> getNotesBySubjectAndDate(String subject, String date)
            throws IncorrectDataException, DateTimeParseException {
        List<Note> result = new ArrayList<>();

        checkString(subject);

        LocalDate localDate = LocalDate.parse(date);

        for (Note note : notes){
            LocalDate date1 = note.getDate().
                    toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if (localDate.equals(date1) && subject.equals(note.getSubject())){
                result.add(note);
            }
        }

        Collections.sort(result);
        return result;
    }

    /**
     * Returns tree set containing the all elements by email.
     * @throws IncorrectDataException if the string equals {@code null} or
     * is empty.
     */
    @Override
    public List<Note> getNotesByEmail(String email) throws IncorrectDataException {
        List<Note> result = new ArrayList<>();

        if (!EMAIL_PATTERN.matcher(email.trim()).matches()){
            throw new IncorrectDataException("E-mail is wrong", email);
        }

        for (Note note : notes){
            if (email.trim().equals(note.getEmail())){
                result.add(note);
            }
        }

        Collections.sort(result);
        return result;
    }

    /**
     * Returns tree set containing the given content.
     * @throws IncorrectDataException if the string equals {@code null} or
     * is empty.
     */
    @Override
    public List<Note> getNotesByContent(String content) throws IncorrectDataException {
        List<Note> result = new ArrayList<>();

        checkString(content);

        for (Note note : notes){
            if (note.getContent() != null &&
                    (note.getContent().trim().equals(content.trim())
                            || note.getContent().contains(content.trim()))){
                result.add(note);
            }
        }

        Collections.sort(result);
        return result;
    }

    /**
     * Pattern for check email.
     */
    public static final Pattern EMAIL_PATTERN = Pattern.compile(".{1,64}@.+\\..+");

    /**
     * Checks the string on {@code null} and {@code empty}.
     * @throws IncorrectDataException if the string equals {@code null} or
     * is empty.
     */
    private void checkString(String string) throws IncorrectDataException {
        if (string != null && string.trim().isEmpty()){
            throw new IncorrectDataException("Incorrect data.", string);
        }
    }

    /**
     * Adds new {@link Note}.
     *
     * @throws IncorrectDataException if  inputs don't correct data,
     * {@code subject} and {@code content} are empty together,
     * {@code email} don't equals pattern {@code EMAIL_PATTER} or longer than 254 chars.
     */
    @Override
    public void add(String subject, String email, String content) throws IncorrectDataException {
        if (email.trim().isEmpty() ||
                !EMAIL_PATTERN.matcher(email.trim()).matches()
                || email.trim().length() > 254) {
            throw new IncorrectDataException("Incorrect e-mail address.", email);
        }

        if (subject.trim().isEmpty() && content.trim().isEmpty()){
            throw new IncorrectDataException(
                    "'Subject' and 'Content' don't be empty together.", null);
        }

        notes.add(new Note(subject.trim(), email.trim(), content.trim()));
    }

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
