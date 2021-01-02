package by.epam.learn.multithread;

import java.util.concurrent.TimeUnit;

public class ThreadException {
    // потоки независимы друг от друга при генерации исключений
    public static void main(String[] args) {
        new Thread(() -> {
            boolean flag = true;
            if (flag){
                throw new RuntimeException();
            }
            System.out.println("End of except thread");
        }).start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end of main");
    }
}
