package completableFuture;

import java.util.concurrent.*;

public class Demo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletableFuture<Integer> f1 = CompletableFuture
                .supplyAsync(() -> Calculator.add(2, 3), executor);

        CompletableFuture<Integer> f2 = CompletableFuture
                .supplyAsync(() -> Calculator.add(1,3), executor);

        CompletableFuture<Void> f3 = CompletableFuture
                .runAsync(() -> Calculator.add(1, 10), executor);

//        System.out.println(f1.get(1, TimeUnit.SECONDS));
        System.out.println("Main End");
        executor.shutdown();
    }
}
