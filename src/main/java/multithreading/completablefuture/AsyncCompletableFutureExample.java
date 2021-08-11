package multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class AsyncCompletableFutureExample {

    public static void main(String[] args) {
        // Использование лямбда-выражения
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            // Имитация длительной работы
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("Я буду работать в отдельном потоке, а не в главном.");
        });
    }
}
