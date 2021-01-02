package by.epam.learn.multithread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDemo {
    public static void main(String[] args) {
        WalkThread walk = new WalkThread();
        Thread talk = new Thread(new TalkThread());

        // Never don't start thread in a constructor
        walk.start();
        talk.start();

        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(new CallThread());
        try {
            String string = future.get();
            System.out.println(string);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Thread.currentThread().stop();
    }
}
