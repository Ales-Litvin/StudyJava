package multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ThenApplyCompletableFutureExample {

    public static void main(String[] args)
            throws ExecutionException, InterruptedException {
        // Создаём CompletableFuture
        CompletableFuture<String> whatsYourNameFuture =
                CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Rajeev";
        });

        // Добавляем колбэк к Future, используя thenApply()
        CompletableFuture<String> greetingFuture
                = whatsYourNameFuture.thenApply(name -> {
            return "Привет," + name;
        });

        // Блокировка и получение результата Future
        System.out.println(greetingFuture.get()); // Привет, Rajeev
    }
}
