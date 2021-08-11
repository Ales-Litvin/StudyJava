package by.epam.learn.exception.maintask;

import java.util.List;
import java.util.Objects;

public class Faculty {
    private String name;

    private List<StudentsGroup> groups;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<StudentsGroup> getGroups() { return groups; }

    public void setGroups(List<StudentsGroup> groups) { this.groups = groups; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(name, faculty.name) &&
                Objects.equals(groups, faculty.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, groups);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", groups=" + groups +
                '}';
    }
}
