package by.epam.learn.multithread.tasks.maintask.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// This is resources
public class Port {

    private final List<Pier> piers;

    private static final int MAX_PIERS = 3;
    private static final int MAX_CAPACITY = 500;

    private int amount;

    public Port(Tunnel tunnel) {
        this.piers = new ArrayList<>();
        this.amount = 300;
        for (int i = 0; i < MAX_PIERS; i++) {
            piers.add(new Pier(tunnel, this, i));
        }
    }

    public List<Pier> getPiers() {
        return piers;
    }

    // returns true if can take 'containers'
    public synchronized boolean canTake() {
        return amount < MAX_CAPACITY;
    }

    // returns ture if can give 'containers'
    public synchronized boolean canGive() {
        return amount != 0;
    }

    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    // producer
    public void add(int count) {
        try {
            lock.lock();

            while (this.amount >= MAX_CAPACITY) {
                condition.await();
            }

            // program logic
            this.amount += count;
            System.out.printf(
                    "Port '%d' containers. " +
                            "From %s to %s '%d' containers.\n",
                    this.amount,
                    Thread.currentThread().getName(),
                    this.getClass().getSimpleName(),
                    count);

        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            condition.signalAll();
            lock.unlock();
        }
    }

    // consumer
    // returns count of unloaded products
    public int get(int count) {
        try {
            lock.lock();

            while (this.amount <= 0) {
                condition.await();
            }

            if (this.amount >= count) {
                this.amount -= count;
            } else {
                count = this.amount;
                this.amount = 0;
            }

            System.out.printf(
                    "Port '%d' containers. " +
                            "From %s to %s '%d' containers.\n",
                    this.amount,
                    this.getClass().getSimpleName(),
                    Thread.currentThread().getName(),
                    count);

            return count;
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            condition.signalAll();
            lock.unlock();
        }
        return 0;
    }

    public String getInfo() {
        int containers = 0;
        try {
            lock.lock();
            containers = amount;
        } finally {
            lock.unlock();
        }
        return String.format("%s: '%d' containers.\n",
                Thread.currentThread().getName(),
                containers);
    }
}
