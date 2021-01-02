package by.epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task05;

/*
 * Условие задачи:
 * 5. Опишите класс, реализующий десятичный счетчик, который может увеличивать
 *    или уменьшать совое занчение на удиницу в заданном диапазоне.
 *    Предусмотрите нинициализацию счетчика занчениями по умолчанию
 *    и произвольными значениями. Счетчик имеет методы увеличения и уменьшения
 *    состояния, и метод позволяющий получить его текущее состояние. Написать
 *    код, демонстрирующий все возможности класса.
 */
public class DecimalCounter {
    // method for testing
    public static void main(String[] args) {
        DecimalCounter counter = new DecimalCounter(10);

        counter.plus();
        System.out.println(counter.getCurrentValue());

        counter.minus();
        System.out.println(counter.getCurrentValue());
    }

    private int currentValue;

    /**
     * Initializes counter with the given value.
     * @param startValue a start value.
     */
    public DecimalCounter(int startValue) { this.currentValue = startValue; }

    /**
     * Initializes counter with value by default.
     */
    public DecimalCounter() { this.currentValue = 0; }

    /**
     * Increases the current value by one
     */
    public void plus(){
        currentValue++;
    }

    /**
     * Decreases the current value by one
     */
    public void minus(){
        currentValue--;
    }

    // getter
    public int getCurrentValue() {
        return currentValue;
    }
}
