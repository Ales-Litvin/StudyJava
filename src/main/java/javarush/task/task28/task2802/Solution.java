package javarush.task.task28.task2802;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/*
Пишем свою ThreadFactory
*/
public class Solution {

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    /*
     * В классе Solution создай публичный статический класс AmigoThreadFactory,
     *  реализующий интерфейс ThreadFactory.
     *             1. Реализация интерфейсного метода - создайте и верните трэд, который должен:
     *             1.1. не быть демоном,
     *             1.2. иметь нормальный приоритет,
     *             1.3. имя трэда должно иметь шаблон "GN-pool-A-thread-B",
     *     где GN - это имя группы,
     *     A - это номер фабрики инкрементируется в пределах класса начиная с 1,
     *         используйте AtomicInteger,
     *     B - номер треда инкрементируется в пределах конкретной фабрики начиная с 1,
     *         используйте AtomicInteger.
     *             2. Каждая фабрика должна иметь ту группу тредов (ThreadGroup),
     *                в которой она была создана.
     *             3. Методы learn.main и emulateThreadFactory не участвуют в тестировании.
    Пример вывода:
    secondGroup-pool-2-thread-1
    firstGroup-pool-1-thread-1
    firstGroup-pool-1-thread-3
    secondGroup-pool-2-thread-3
    firstGroup-pool-1-thread-2
    secondGroup-pool-2-thread-2
     */

    public static class AmigoThreadFactory implements ThreadFactory {
        private static AtomicInteger countFactory = new AtomicInteger(0);
        private AtomicInteger countThread = new AtomicInteger(0);

        public AmigoThreadFactory(){
            countFactory.getAndIncrement();
        }

        @Override
        public Thread newThread(Runnable r) {
            countThread.getAndIncrement();
            String threadName = String.format("%s-pool-%d-thread-%d",
                    Thread.currentThread().getThreadGroup().getName(),
                    countFactory.get(),
                    countThread.get());
            Thread result = new Thread(r, threadName);
            result.setDaemon(false);
            result.setPriority(Thread.NORM_PRIORITY);
            return result;
        }
    }
}