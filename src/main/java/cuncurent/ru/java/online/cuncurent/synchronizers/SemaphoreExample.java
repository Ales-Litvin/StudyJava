package cuncurent.ru.java.online.cuncurent.synchronizers;

import java.util.concurrent.Semaphore;

/**
 * Semaphore (семафор) — объект синхронизации, ограничивающий одновременный
 * доступ к общему ресурсу нескольким потокам с помощью счетчика.
 * При запросе разрешения и значении счетчика больше нуля доступ предоставляется,
 * а счетчик уменьшается; в противном случае — доступ запрещается.
 * При освобождении ресурса значение счетчика семафора увеличивается.
 * Количество разрешений семафора определяется в конструкторе.
 * Второй конструктор семаформа включает дополнительный параметр «справедливости»,
 * определяющий порядок предоставления разрешения ожидающим доступа потокам.
 *
 * Чтобы получить у семафора разрешение необходимо вызвать у него один
 * из перегруженных методов acquire :
 * void acquire()           throws InterruptedException
 * void acquire(int number) throws InterruptedException
 *
 * Чтобы освободить разрешение у семафора следует вызвать у него один
 * из перегруженных методов release :
 * void release()
 * void release(int number)
 */
public class SemaphoreExample {

    private static final int COUNT_CONTROL_PLACES = 5;
    private static final int COUNT_RIDERS = 7;

    // Флаги мест контроля
    private static boolean[] CONTROL_PLACES = null;

    // Семафор
    private static Semaphore SEMAPHORE = null;

    public static class Rider implements Runnable {
        private int ruderNum;

        public Rider(int ruderNum) {
            this.ruderNum = ruderNum;
        }

        @Override
        public void run() {
            System.out.printf("Всадник %d подошел к зоне контроля\n", ruderNum);

            try {
                // Запрос разрешения
                SEMAPHORE.acquire();
                System.out.printf(
                        "\tвсадник %d проверяет наличие свободного контроллера\n", ruderNum);
                int controlNum = -1;
                // Ищем свободное место и
                // подходим к контроллеру
                synchronized (CONTROL_PLACES) {
                    for (int i = 0;
                         i < COUNT_CONTROL_PLACES; i++)
                        // Есть ли свободные контроллеры?
                        if (CONTROL_PLACES[i]) {
                            // Занимаем место
                            CONTROL_PLACES[i] = false;
                            controlNum = i;
                            System.out.printf(
                                    "\t\tвсадник %d подошел к контроллеру % d.\n",
                                    ruderNum, i);
                            break;
                        }
                }

                // Время проверки лошади и всадника
                Thread.sleep((int)
                        (Math.random() * 10 + 1) * 1000);

                // Освобождение места контроля
                synchronized (CONTROL_PLACES) {
                    CONTROL_PLACES[controlNum] = true;
                }

                // Освобождение ресурса
                SEMAPHORE.release();
                System.out.printf("Всадник %d завершил проверку\n", ruderNum);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args)
            throws InterruptedException {
        // Определяем количество мест контроля
        CONTROL_PLACES = new boolean[COUNT_CONTROL_PLACES];
        // Флаги мест контроля [true-свободно,false-занято]
        for (int i = 0; i < COUNT_CONTROL_PLACES; i++)
            CONTROL_PLACES[i] = true;
        /*
         *  Определяем семафор со следующими параметрами :
         *  - количество разрешений 5
         *  - флаг очередности fair=true (очередь
         *                             first_in-first_out)
         */
        SEMAPHORE = new Semaphore(CONTROL_PLACES.length, true);

        for (int i = 1; i <= COUNT_RIDERS; i++) {
            new Thread(new Rider(i)).start();
            Thread.sleep(400);
        }
    }
}
