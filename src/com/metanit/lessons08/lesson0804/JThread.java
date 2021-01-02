package com.metanit.lessons08.lesson0804;

class JThread extends Thread {

    JThread(String name) {
        super(name);
    }

    @Override
    public void run() {

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter = 1; // счетчик циклов
        while (!isInterrupted()) {
            System.out.println("Loop " + counter++);
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}
