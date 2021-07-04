package cuncurent.ru.java.online.cuncurent.queues.nonblocking;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * ConcurrentLinkedQueue реализуют интерфейс Queue и формирует неблокирующую
 * и ориентированную на многопоточное исполнение очередь.
 * Размер очереди ConcurrentLinkedQueue не имеет ограничений.
 * Имплементация очереди использует wait-free алгоритм от Michael & Scott,
 * адаптированный для работы с garbage collector'ом. Данный алгоритм довольно
 * эффективен и очень быстр, т.к. построен на CAS (Compare-And-Swap)
 *
 */
public class ConcurrentLinkedQueueExample {
    private Queue<String> queue = null;

    private volatile boolean cycle = true;

    ConcurrentLinkedQueueExample() {
        queue = new ConcurrentLinkedQueue<String>();

        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());
        producer.start();
        consumer.start();

        while (consumer.isAlive()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }

    class Producer implements Runnable {

        public void run() {
            System.out.println("Producer started");
            try {
                for (int i = 1; i <= 10; i++) {
                    String str = "String" + i;
                    queue.add(str);
                    System.out.println("Producer added : "
                            + str);
                    Thread.sleep(200);
                }
                cycle = false;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    class Consumer implements Runnable {
        public void run() {
            String str;
            System.out.println("Consumer started\n");
            while (cycle || queue.size() > 0) {
                if ((str = queue.poll()) != null)
                    System.out.println("  consumer removed : "
                            + str);
                try {
                    Thread.sleep(500);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new ConcurrentLinkedQueueExample();
    }
}
