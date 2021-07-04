package multithreading.forkjoinpool.ex1;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        int[] array = getInitArray(1000);
        ValueSumCounter counter = new ValueSumCounter(array);
        System.out.println(new Date());
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println(forkJoinPool.invoke(counter));
        System.out.println(new Date());
    }

    private static int[] getInitArray(int i) {
        int[] array = new int[i];
        for (int j = 0; j < i; j++) {
            array[j] = 3;
        }
        return array;
    }
}
