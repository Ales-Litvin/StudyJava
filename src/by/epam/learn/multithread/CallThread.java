package by.epam.learn.multithread;

import java.util.concurrent.Callable;

public class CallThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            sb.append("Call " + i + " ");
            System.out.println("Call " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
