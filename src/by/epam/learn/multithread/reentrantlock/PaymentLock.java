package by.epam.learn.multithread.reentrantlock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PaymentLock {
    private int amount;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();

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
        } finally {
            lock.unlock();
        }
    }

    public synchronized void init(){
        try {
            lock.lock();
            System.out.println("Init amount:");
            amount = new Scanner(System.in).nextInt();
        } finally {
            condition.signalAll();
            lock.unlock();
        }
    }
}
