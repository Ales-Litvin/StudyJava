package javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private int age;
    private String name;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for (Student student : students){
            if (student.getAverageGrade() == averageGrade)
                return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student studentMax = students.get(0);
        for (Student student : students){
            if (student.getAverageGrade() > studentMax.getAverageGrade())
                studentMax = student;
        }
        return studentMax;
    }

    public void expel(Student student){
        students.remove(student);
    }

    public Student getStudentWithMinAverageGrade(){
        Student studentMin = students.get(0);
        for (Student student : students){
            if (student.getAverageGrade() < studentMin.getAverageGrade())
            studentMin = student;
        }
        return studentMin;
    }
}