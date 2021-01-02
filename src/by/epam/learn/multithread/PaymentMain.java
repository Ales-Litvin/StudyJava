package by.epam.learn.multithread;

import java.util.concurrent.TimeUnit;

public class PaymentMain {
    public static void main(String[] args) {
        Payment payment = new Payment();

        for (int i = 0; i < 5; i++) {
            new Thread (() -> payment.doPayment()).start();
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        payment.init();
    }
}
