package by.epam.learn.multithread.reentrantlock;

import java.util.concurrent.TimeUnit;

public class PaymentLockRunner {
    public static void main(String[] args) {
        final PaymentLock payment = new PaymentLock();

        new Thread(() -> payment.doPayment()).start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        payment.init();
        System.out.println("The end of main");

    }
}
