package by_epam.introduction_to_java.tasks_6.task03.entity;

import javax.xml.bind.annotation.*;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Objects;

/**
 * The class for stores data.
 */
@XmlRootElement(name = "dossier")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"firstname", "surname", "content"})
public class Dossier implements Externalizable {

    private String firstname;
    private String surname;

    private String content;

    @XmlAttribute(name = "id")
    private long id;

    public Dossier(String firstname, String surname, String content, long id) {
        this.firstname = firstname;
        this.surname = surname;
        this.content = content;
        this.id = id;
    }

    public Dossier() {}

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dossier)) return false;
        Dossier dossier = (Dossier) o;
        return getId() == dossier.getId() &&
                Objects.equals(getFirstname(), dossier.getFirstname()) &&
                Objects.equals(getSurname(), dossier.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstname(), getSurname(), getId());
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getFirstname());
        out.writeObject(this.getSurname());
        out.writeObject(this.getContent());
        out.writeObject(this.getId());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.firstname = (String) in.readObject();
        this.surname = (String) in.readObject();
        this.content = (String) in.readObject();
        this.id = (long) in.readObject();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dossier{");
        sb.append("firstname='").append(firstname).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}