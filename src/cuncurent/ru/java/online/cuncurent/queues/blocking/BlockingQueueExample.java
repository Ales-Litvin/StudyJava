package cuncurent.ru.java.online.cuncurent.queues.blocking;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ArrayBlockingQueue — блокирующая очередь, реализующая классический кольцевой
 * буфер. Параметр fair в конструкторе позволяет управлять справедливостью
 * очереди для упорядочивания работы ожидающих потоков производителей
 * (вставляющих элементы) и потребителей (извлекающих элементы).
 *
 * ArrayBlockingQueue реализует классический ограниченного размера кольцевой
 * буфер FIFO — «первым прибыл - первым убыл». Новые элементы вставляются в
 * хвост очереди; операции извлечения отдают элемент из головы очереди.
 * Создаваемая емкость очереди не может быть изменена.
 * Попытки вставить (put) элемент в полную очередь приведет к блокированию работы
 * потока; попытка извлечь (take) элемент из пустой очереди также блокирует поток.
 *
 */
public class BlockingQueueExample {
    private BlockingQueue<String> drop;

    private final String DONE = "done";
    private final String[] messages = {
            "Мама пошла готовить обед",
            "Мама позвала к столу",
            "Дети кушают молочную кашу",
            "А что ест папа?"};

    public BlockingQueueExample() {
        drop = new ArrayBlockingQueue<String>(1, true);
        (new Thread(new Producer())).start();
        (new Thread(new Consumer())).start();
    }

    class Producer implements Runnable {
        public void run() {
            try {
                int cnt = 0;
                for (int i = 0; i < messages.length; i++) {
                    drop.put(messages[i]);
                    if (++cnt < 3)
                        Thread.sleep(2000);
                }
                drop.put(DONE);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    class Consumer implements Runnable {
        public void run() {
            try {
                String msg = null;
                while (!((msg = drop.take()).equals(DONE)))
                    System.out.println(msg);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new BlockingQueueExample();
    }
}
