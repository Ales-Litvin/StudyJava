package com.metanit.lessons08.lesson0804;

class MyThread implements Runnable {

    private boolean isActive;

    void disable() {
        isActive = false;
    }

    MyThread() { isActive = true; }

    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter = 1; // счетчик циклов
        while (isActive) {
            System.out.println("Loop " + counter++);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}
