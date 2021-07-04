package multithreading.completablefuture;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class SupplierAsyncCompletableFutureExample {

    public static void main(String[] args)
            throws ExecutionException, InterruptedException {
        // Запуск асинхронной задачи, заданной объектом Supplier
        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
                return "Результат асинхронной задачи";
            }
        });

        // Блокировка и получение результата Future
        String result = future.get();
        System.out.println(result);

        Executor executor = Executors.newFixedThreadPool(10);
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Результат асинхронной задачи";
        }, executor);
    }
}
