package by.epam.learn.exception.maintask;

import by.epam.learn.exception.maintask.exception.NotDisciplinesException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {
    private String name;

    private List<Discipline> disciplines;

    public Student(String name) {
        this.name = name;
        this.disciplines = new ArrayList<>();
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<Discipline> getDisciplines() { return disciplines; }

    public void setDisciplines(List<Discipline> disciplines) { this.disciplines = disciplines; }

    public int getAverageGrade() throws NotDisciplinesException {
        if (disciplines.size() == 0) throw new NotDisciplinesException();

        int sum = 0;
        for (Discipline discipline : disciplines){
            sum += discipline.getAverageGrade();
        }
        return sum / disciplines.size();
    }

    public int getAverageGrade(String discipleName){
        return this.disciplines.stream().filter(discipline -> discipline.getName().equals(discipleName)).findFirst().get().
                getGrades().stream().reduce(0, Integer::sum);
    }

    public boolean add(Discipline discipline){
        return this.disciplines.add(discipline);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(disciplines, student.disciplines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, disciplines);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", disciplines=" + disciplines +
                '}';
    }
}
