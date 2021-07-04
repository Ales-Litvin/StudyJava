package multithreading.forkjoinpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SimpleStringRecursiveTask extends RecursiveTask<String> {

    @Override
    protected String compute() {
        return "I am just innocent simple class";
    }

    public static void main(String[] args) {
        SimpleStringRecursiveTask simpleTask = new SimpleStringRecursiveTask();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println(forkJoinPool.invoke(simpleTask));
    }
}
