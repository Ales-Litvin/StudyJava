package by.epam.learn.multithread.tasks.optionaltask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * Optional Task
 * В аэропорту есть 5 взлетно-посадочных полос. Самолету требуется 3 минуты
 * чтобы выйти на полосу, набрать скорость и взлететь. После этого полоса
 * свободна для вылета следующего самолета. Реализовать симуляцию вылета 10
 * самолетов используя все доступные полосы. 1 минуту реально времени заменить
 * на 1 секунду в симуляции. Вывести в консоль информацию о следующих событиях:
 *
 *
 * - Самолет начал выход на полосу
 * - Самолет взлетел
 * - Полоса "приняла" самолет
 * - Полоса освободилась
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Available number of cores: "
                + Runtime.getRuntime().availableProcessors());

        Airport airport = new Airport();

        PlaneGenerator generator = new PlaneGenerator(airport, 10);

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(generator);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }


        for (Dispatcher dispatcher : airport.getDispatchers()){
            service.execute(dispatcher);
        }

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        service.shutdown();
    }
}
