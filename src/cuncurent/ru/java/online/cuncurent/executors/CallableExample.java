package cuncurent.ru.java.online.cuncurent.executors;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 *  Callable<V> — расширенный аналог интерфейса Runnable, позволяющий возвращать
 *  типизированное значение. В интерфейсе используется метод call, являющийся
 *  аналогом метода run интерфейса Runnable.
 *
 * Future<V> — интерфейс для получения результатов работы потока.
 * Объект данного типа возвращает сервис исполнения ExecutorService,
 * который в качестве параметра получает объект типа Callable<V>. Метод get
 * объекта Future блокирует текущий поток (с таймаутом или без) до завершения
 * работы потока Callable. Кроме этого, интерфейс Future включает методы для
 * отмены операции и проверки текущего статуса. В качестве имплементации часто
 * используется класс FutureTask.
 *
 */
public class CallableExample {

    public CallableExample() {
        // Определяем пул из трех потоков
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Список ассоциированных с Callable задач Future
        List<Future<String>> futures = new ArrayList<Future<String>>();

        // Создание экземпляра Callable класса
        Callable<String> callable = new CallableClass();

        for (int i = 0; i < 3; i++) {
            /*
             * Стартуем возвращаюший результат исполнения
             * в виде объекта Future поток
             */
            Future<String> future;
            future = executor.submit(callable);
            /*
             * Добавляем объект Future в список для
             * отображения результат выполнения (получение
             * наименования потока)
             */
            futures.add(future);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss  ");

        for (Future<String> future : futures) {
            try {
                // Выводим в консоль полученное значение
                String text = sdf.format(new Date()) + future.get();
                System.out.println(text);
            } catch (InterruptedException | ExecutionException e) {
            }
        }
        // Останавливаем пул потоков
        executor.shutdown();
    }

    //-----------------------------------------------------
    // Класс, реализующий интерфейс Callable
    class CallableClass implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            // наименование потока, выполняющего
            // callable задачу
            return Thread.currentThread().getName();
        }
    }

    //-----------------------------------------------------
    public static void main(String args[]) {
        new CallableExample();
    }
}
