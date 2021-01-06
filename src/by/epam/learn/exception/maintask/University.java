package by.epam.learn.exception.maintask;

import java.util.List;
import java.util.Objects;

public class University {
    private String name;

    private List<Faculty> faculties;

    public University(String name, List<Faculty> faculties) {
        this.name = name;
        if (faculties.isEmpty()) throw new IllegalArgumentException();
        this.faculties = faculties;
    }

    public String getName() { return name;}

    public void setName(String name) { this.name = name; }

    public List<Faculty> getFaculties() { return faculties; }

    public void setFaculties(List<Faculty> faculties) { this.faculties = faculties; }

    public boolean add(Faculty faculty){
        if (faculty == null) throw new IllegalArgumentException();
        return this.faculties.add(faculty);
    }

    public int getAverageGrade(String disciplineName, String groupName, String facultyName){
        this.faculties.stream().filter(faculty -> faculty.getName().equals(facultyName)).findFirst().get().
                getGroups().stream().filter(studentsGroup -> studentsGroup.getName().equals(groupName)).findFirst().get().
                getStudents().stream().forEach(i -> System.out.println(i));
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(faculties, that.faculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, faculties);
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", faculties=" + faculties +
                '}';
    }
}
