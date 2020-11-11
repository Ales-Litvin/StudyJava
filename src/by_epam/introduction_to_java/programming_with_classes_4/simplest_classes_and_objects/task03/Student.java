package by_epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task03;

/*
 * Условие задачи:
 * 3. Создайте класс  с именем Student, содержащий  поля:
 *    фамилия и инициалы,
 *    номер группы,
 *    успеваемость (массив из пяти элементов).
 *  Создайте массив из десяти элементов такого типа.
 *  Добавьте возможность вывода фамилий и номеров групп студентов, имеющих
 *  оценки, равные только 9 или 10.
 */


public class Student {
    // just method for testing
    public static void main(String[] args) {
        // создаем массив из 10 студентов
        Student[] students = CreateHelper.getStudents(10);

        // создадим отличника т.к. в массиве одни случаные двойшники
        int[] bestScore = {10, 9, 9, 10, 10};
        Student bestStudent = new Student("Petrov P.P.",
                100,
                bestScore);

        // добавим его к двойшникам
        students[9] = bestStudent;

        // Выводим фамилии и номера групп для студентов имеющих оценки равные только 9 и 10
        printAllBestStudents(students, 9);
    }

    private String name;
    private int numberOfGroup;
    private int[] academicPerformance;

    public Student(String name, int numberOfGroup, int[] academicPerformance) {
        this.name = name;
        this.numberOfGroup = numberOfGroup;
        this.academicPerformance = new int[5];
        if (academicPerformance.length != 5) {
            System.out.println("{@param academicPerformance} must be length of '5'.");
        }
        System.arraycopy(academicPerformance, 0,this.academicPerformance, 0, 5);
    }

    // getters and setters


    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getNumberOfGroup() { return numberOfGroup; }

    public void setNumberOfGroup(int numberOfGroup) { this.numberOfGroup = numberOfGroup; }

    public int[] getAcademicPerformance() { return academicPerformance; }

    public void setAcademicPerformance(int[] academicPerformance) {
        if (academicPerformance.length != 5) {
            System.out.println("{@param academicPerformance} must be length of '5'.");
        } else {
            this.academicPerformance = academicPerformance;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", numberOfGroup=").append(numberOfGroup);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Printing of students who have score more than minimum score {@param minimumScore}
     * @param students a array students
     * @param minimumScore a minimum score
     */
    public static void printAllBestStudents(Student[] students, int minimumScore){
        for (Student student : students){
            boolean isBestStudent = true;
            for (int i : student.getAcademicPerformance()){
                if (i < minimumScore) {
                    isBestStudent = false;
                    break;
                }
            }
            if (isBestStudent) {
                System.out.println(student);
            }
        }
    }
}
