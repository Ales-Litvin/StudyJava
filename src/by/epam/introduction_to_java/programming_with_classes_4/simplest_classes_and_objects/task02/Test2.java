package by.epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task02;

/*
 * Условие задачи:
 * 2.  Создйте  класс  Test2  двумя  переменными.
 *     Добавьте  конструктор  с  входными  параметрами.
 *     Добавьте конструктор, инициализирующий члены класса по умолчанию.
 *     Добавьте set- и get- методы для полей экземпляра класса.
 */

public class Test2 {
    // just method for testing
    public static void main(String[] args) {
        Test2 test = new Test2(5, 15);
        System.out.println(test);

        Test2 test2 = new Test2();
        System.out.println(test2);
    }


    private int firstVariable;
    private int secondVariable;

    public Test2(int firstVariable, int secondVariable) {
        this.firstVariable = firstVariable;
        this.secondVariable = secondVariable;
    }

    /**
     * Initializes values to default values
     */
    public Test2() { }

    // getters and setters
    public int getFirstVariable() { return firstVariable; }

    public void setFirstVariable(int firstVariable) { this.firstVariable = firstVariable; }

    public int getSecondVariable() { return secondVariable; }

    public void setSecondVariable(int secondVariable) { this.secondVariable = secondVariable; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Test2{");
        sb.append("firstVariable=").append(firstVariable);
        sb.append(", secondVariable=").append(secondVariable);
        sb.append('}');
        return sb.toString();
    }
}
