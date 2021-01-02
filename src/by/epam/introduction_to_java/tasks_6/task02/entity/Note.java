package by.epam.introduction_to_java.tasks_6.task02.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * The {@code Note} class represents note.
 * <p>
 * {@code Note} are constant; their values cannot be changed after they
 * are created.
 *
 * @author  Aliaksandr Rachko
 * @version 1.0
 */
public class Note implements Comparable<Note>, Serializable {

    /**
     * Note's subject.
     */
    private final String subject;

    /**
     * Date of created.
     */
    private final Date date;

    /**
     * Just email.
     */
    private final String email;

    /**
     * Note's content
     */
    private final String content;

    public Note(String subject, String email, String content) {
        this.subject = subject;
        this.date = new Date();
        this.email = email;
        this.content = content;
    }

    // getters
    public String getSubject() { return subject; }

    public Date getDate() { return date; }

    public String getEmail() { return email; }

    public String getContent() { return content; }

    @Override
    public int compareTo(Note o) {
        return this.getDate().compareTo(o.getDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note)) return false;
        Note note = (Note) o;
        return Objects.equals(getSubject(), note.getSubject()) &&
                Objects.equals(getDate(), note.getDate()) &&
                Objects.equals(getEmail(), note.getEmail()) &&
                Objects.equals(getContent(), note.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubject(), getDate(), getEmail(), getContent());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Note{");
        sb.append("subject='").append(subject).append('\'');
        sb.append(", date=").append(date);
        sb.append(", email='").append(email).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
