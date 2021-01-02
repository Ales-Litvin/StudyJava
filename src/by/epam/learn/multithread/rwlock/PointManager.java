package by.epam.learn.multithread.rwlock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PointManager {

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public PointManager() { }

    public double length(Point point){
        double length = 0;
        try {
            readLock.lock();
            System.out.println(" read lock 1:    " + Thread.currentThread().getName());
            TimeUnit.MILLISECONDS.sleep(50);
            length = Math.hypot(point.getX(), point.getY()); // method code
            TimeUnit.MILLISECONDS.sleep(50);
            System.out.println(" read lock 2:    " + Thread.currentThread().getName());
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
        return length;
    }

    public void randomChangePoint(Point point){
        try {
            writeLock.lock();
            System.out.println(" writeLock begin:    " + Thread.currentThread().getName());
            TimeUnit.MILLISECONDS.sleep(50);
            point.setX(point.getX() + (5 - new Random().nextInt(10) / 2.0));
            point.setY(point.getY() + (5 - new Random().nextInt(10) / 2.0));
            TimeUnit.MILLISECONDS.sleep(50);
            System.out.println(" writeLock end:    " + Thread.currentThread().getName());
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }
}


