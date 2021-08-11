package com.metanit.lessons08.lesson0809;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class CountThread implements Runnable {

    CommonResource resource;
    ReentrantLock locker;

    public CountThread(CommonResource resource, ReentrantLock locker) {
        this.resource = resource;
        this.locker = locker;
    }

    @Override
    public void run() {
        locker.lock(); // устанавливаем блокировку
        try {
            resource.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.printf("%s %d \n",
                        Thread.currentThread().getName(), resource.x);
                resource.x++;
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock(); // снимаем блокировку
        }
    }
}
