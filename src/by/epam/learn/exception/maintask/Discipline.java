package by.epam.learn.exception.maintask;

import java.util.*;

public class Discipline {
    private String name;

    private List<Integer> grades;

    public Discipline(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public Discipline(String name, int ... grades) throws IllegalArgumentException{
        this.name = name;
        this.grades = new ArrayList<>();
        for (int grade : grades){
            if (!isValidGrade(grade)){
                throw new IllegalArgumentException("grade : '" + grade + "'");
            } else {
                this.grades.add(grade);
            }
        }
    }

    public boolean isValidGrade(int grade){ return grade >= 0 && grade <= 10; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<Integer> getGrades() { return grades; }

    public void setGrades(List<Integer> grades) { this.grades = grades; }

    public boolean add(int grade) throws IllegalArgumentException{
        if (!isValidGrade(grade)){
            throw new IllegalArgumentException("grade : '" + grade + "'");
        } else {
            return this.grades.add(grade);
        }
    }

    public int getAverageGrade() {
        if (grades.size() == 0) return 0;
        int sum = this.grades.stream().reduce(0, Integer::sum);
        return sum / grades.size();
    }

    public int getAverageGrade(Discipline discipline){
        return (this.getAverageGrade() + discipline.getAverageGrade()) / 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discipline that = (Discipline) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(grades, that.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grades);
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "name='" + name + '\'' +
                ", grades=" + grades +
                '}';
    }
}
