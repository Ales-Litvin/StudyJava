package by_epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task01;

/*
 * Условие задачи:
 * 1.  Создайте  класс  Test1  двумя  переменными.
 *     Добавьте  метод  вывода  на  экран  и  методы  изменения  этих переменных.
 *     Добавьте  метод,  который  находит  сумму  значений  этих  переменных,
 *     и  метод,  который  находит наибольшее значение из этих двух переменных.
 */

public class Test1 {
    // just method for testing
    public static void main(String[] args) {
        Test1 test1 = new Test1(5, 15);

        System.out.println(test1);
        System.out.println(test1.sum());
        System.out.println(test1.max());
    }


    private int firstVariable;
    private int secondVariable;

    public Test1(int firstVariable, int secondVariable) {
        this.firstVariable = firstVariable;
        this.secondVariable = secondVariable;
    }

    // getters and setters
    public int getFirstVariable() { return firstVariable; }

    public void setFirstVariable(int firstVariable) { this.firstVariable = firstVariable; }

    public int getSecondVariable() { return secondVariable; }

    public void setSecondVariable(int secondVariable) { this.secondVariable = secondVariable; }

    /**
     * Returns sum of variables.
     * @return sum of variables.
     */
    public int sum(){
        return firstVariable + secondVariable;
    }

    public int max(){
        return Math.max(firstVariable, secondVariable);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Test1{");
        sb.append("firstVariable=").append(firstVariable);
        sb.append(", secondVariable=").append(secondVariable);
        sb.append('}');
        return sb.toString();
    }
}
