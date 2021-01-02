package com.metanit.lessons08.lesson0807;

import java.util.concurrent.Exchanger;

public class Program {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(new PutThread(exchanger)).start();
        new Thread(new GetThread(exchanger)).start();
    }
}
