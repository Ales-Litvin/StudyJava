package javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) { this.queue = queue; }

    @Override
    public void run() {
        try {
            Thread.sleep(450);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while(!Thread.currentThread().isInterrupted()){
            try {
                queue.take();
            } catch (InterruptedException e) {
                //e.printStackTrace(); не выводи стек-трейс в консоль
                Thread.currentThread().interrupt();
            }
            System.out.format("Processing item.toString()\n");
        }
    }
}
