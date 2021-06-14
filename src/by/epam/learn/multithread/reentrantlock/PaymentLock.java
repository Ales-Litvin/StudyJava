package by.epam.learn.multithread.reentrantlock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PaymentLock {
    private int amount;
    private final ReentrantLock lock = new ReentrantLock(true);
    private final Condition condition = lock.newCondition();

    public void doPayment(){
        try {
            lock.lock();
            System.out.println("Start payment:");
            while (amount <= 0) {
                condition.await();
            }
            // payment
            System.out.println("Payment is closed");
        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public synchronized void init(){
        try (Scanner scan = new Scanner(System.in)) {
            lock.lock();
            System.out.println("Init amount:");
            amount = scan.nextInt();
        } finally {
            condition.signalAll();
            lock.unlock();
        }
    }
}
