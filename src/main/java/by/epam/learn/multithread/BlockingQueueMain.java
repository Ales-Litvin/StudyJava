package by.epam.learn.multithread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class BlockingQueueMain {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingDeque<>(5);
        new Thread(() -> {
            for (int i = 0; i < 10; i++){
                try {
                    queue.put("Java" + i);
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Element " + queue.take() + " took");
                    TimeUnit.MILLISECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            TimeUnit.SECONDS.timedJoin(Thread.currentThread(), 10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
