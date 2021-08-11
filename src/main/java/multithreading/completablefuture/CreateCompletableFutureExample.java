package multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CreateCompletableFutureExample {

    public static void main(String[] args)
            throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture = new CompletableFuture<>();
        String s = stringCompletableFuture.get();
    }
}
