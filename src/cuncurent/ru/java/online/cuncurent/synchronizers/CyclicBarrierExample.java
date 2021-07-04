package cuncurent.ru.java.online.cuncurent.synchronizers;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier — объект синхронизации типа «Барьер» используется, как правило,
 * в распределённых вычислениях. Барьерная синхронизация останавливает участника
 * (исполняемый поток) в определенном месте в ожидании прихода остальных потоков
 * группы. Как только все потоки достигнут барьера, барьер снимается и выполнение
 * потоков продолжается. Циклический барьер CyclicBarrier, также, как и CountDownLatch,
 * использует счетчик и похож на него. Отличие связано с тем, что «защелку»
 * нельзя использовать повторно после того, как её счётчик обнулится,
 * а барьер можно использовать (в цикле).
 *
 * Для указания потоку о достижении барьера нужно вызвать один из перегруженных
 * методов await :
 * void await() throws InterruptedException
 * boolean await(long wait, TimeUnit unit) throws InterruptedException;
 */
public class CyclicBarrierExample {
    private static CyclicBarrier FerryBarrier;
    private static final int FerryBoat_size = 3;

    // Переправляющий автомобили паром
    public static class FerryBoat implements Runnable {
        @Override
        public void run() {
            try {
                // Задержка на переправе
                System.out.println("\nЗагрузка автомобилей");
                Thread.sleep(500);
                System.out.println("Паром переправил автомобили\n");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Класс автомобиля
    public static class Car implements Runnable {
        private int carNumber;

        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            try {
                System.out.printf("К переправе подъехал автомобиль %d\n", carNumber);
                // Вызов метода await при подходе к
                // барьеру; поток блокируется в ожидании
                // прихода остальных потоков
                FerryBarrier.await();
                System.out.printf("Автомобиль %d продолжил движение\n", carNumber);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args)
            throws InterruptedException {
        FerryBarrier = new CyclicBarrier(FerryBoat_size, new FerryBoat());
        for (int i = 1; i < 10; i++) {
            new Thread(new Car(i)).start();
            Thread.sleep(400);
        }
    }
}