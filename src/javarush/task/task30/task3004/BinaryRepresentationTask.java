package javarush.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String> {
    private int x;

    public BinaryRepresentationTask(int x) {
        this.x = x;
    }

    /*
     * fork () - отправляет задачу в пул, но не запускает ее выполнение.
     *
     */
    @Override
    protected String compute() {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            BinaryRepresentationTask b1 = new BinaryRepresentationTask(b);
            b1.fork();
            return b1.join() + result;
        }
        return result;
    }
}