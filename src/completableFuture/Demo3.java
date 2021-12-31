package completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo3 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletableFuture<Integer> future = CompletableFuture
                .supplyAsync(() -> Calculator.add(1, 2), executor);

        future.thenApplyAsync(data -> {
            System.out.println("CompletableFuture 1 done");
            System.out.println(data);
            return Calculator.add(1, 3); // CompletableFuture 2
        }).thenApplyAsync(data -> {
            System.out.println("CompletableFuture 2 done");
            System.out.println(data);
            return Calculator.add(2, 3); // CompletableFuture 3
        }).thenAcceptAsync(data -> {
            System.out.println("CompletableFuture 3 done");
            System.out.println(data);
        }).thenRun(() -> {
            System.out.println("Finished!");
        });
        System.out.println("Main End");

        executor.shutdown();
    }
}
