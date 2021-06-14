package by.epam.learn.multithread.producerconsumer;

/*
 * This is producer - consumer
 */
public class WaitNotifySignal {
    private boolean ready;

    public synchronized void consume() {
        while (!ready){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            ready = false;
            notify();
        }
    }

    public synchronized void produce() {
        ready = true;
        notifyAll();
    }
}
