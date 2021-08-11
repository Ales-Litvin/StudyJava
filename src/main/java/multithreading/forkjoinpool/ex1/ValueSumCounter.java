package multithreading.forkjoinpool.ex1;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class ValueSumCounter extends RecursiveTask<Integer> {

    private int[] array;

    public ValueSumCounter(int[] array) {
        this.array = array;
    }

    @Override
    protected Integer compute() {
        if (array.length <= 2) {
            System.out.printf("Task %s execute in thread %s%n\n", this, Thread.currentThread().getName());
            return Arrays.stream(array).sum();
        }
        ValueSumCounter firstHalfArrayValueSumCounter =
                new ValueSumCounter(Arrays.copyOfRange(array, 0, (array.length)/2));

        ValueSumCounter secondHalfArrayValueSumCounter =
                new ValueSumCounter(Arrays.copyOfRange(array, array.length/2, array.length));
        firstHalfArrayValueSumCounter.fork();
        secondHalfArrayValueSumCounter.join();
        return firstHalfArrayValueSumCounter.join() + secondHalfArrayValueSumCounter.join();
    }
}
