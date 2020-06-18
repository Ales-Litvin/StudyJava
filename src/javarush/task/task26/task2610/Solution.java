package javarush.task.task26.task2610;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Мир скучен для скучных людей
*/
public class Solution {

    public static void main(String[] args) throws Exception {

        BlockingQueue queue = new ArrayBlockingQueue(32);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        /*
        Создаем средство, называемое сервисом исполнения
        предназначенному для управления потоками

        Создает пул потоков, который создает новые потоки по мере необходимости,
        но будет повторно использовать ранее созданные потоки,
        когда они станут доступны.
         */
        ExecutorService executorService = Executors.newCachedThreadPool();

        // Завершение выполнения задачи, возвращающей результат в виде объекта Future
        // Ставит задачу в очередь на выполнение
        executorService.submit(producer);
        executorService.submit(consumer);

        Thread.sleep(2000);

        /*
         * Остановка всех активно выполняемых задач,
         * остановка обработки ожидающих задач,
         * возвращение списка задач, ожидающих выполнения
         */
        executorService.shutdownNow();
    }
}