package multithreading.ru.java.online.daemon;


import multithreading.ru.java.online.producerconsumer.Consumer;
import multithreading.ru.java.online.producerconsumer.Producer;
import multithreading.ru.java.online.producerconsumer.Store;

public class Trade {

    public static void main(String[] args) {
        Store store = new Store();

        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

//		new Thread(producer).start();
//		new Thread(consumer).start();

        Thread tp = new Thread(producer);
        Thread tc = new Thread(consumer);

        tp.setDaemon(true);
        tc.setDaemon(true);

        tp.start();
        tc.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nГлавный поток завершен\n");
        System.exit(0);
    }
}
