package javarush.task.task29.task2908;

/**
 * Скласс вычисляет квадрат числа
 */
public class Square implements Computable<Integer, Integer> {
    @Override
    public Integer compute(Integer integer) throws InterruptedException {
        int val = integer.intValue();
        return val * val;
    }
}