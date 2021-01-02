package by.epam.learn.multithread;

import java.util.concurrent.TimeUnit;

public class TimeUnitDemo {
    public static void main(String[] args) throws InterruptedException {
        TimeUnit.MINUTES.sleep(10);

        TimeUnit.MINUTES.timedWait(new Object(), 10);

        TimeUnit.MINUTES.timedJoin(new Thread(), 10);
    }

}
