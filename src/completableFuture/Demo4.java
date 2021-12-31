package completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo4 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletableFuture<Integer> f1 = CompletableFuture
                .supplyAsync(() -> Calculator.add(1,2), executor);
        CompletableFuture<Integer> f2 = CompletableFuture
                .supplyAsync(() -> Calculator.add(1,3), executor);
        CompletableFuture<Integer> f3 = CompletableFuture
                .supplyAsync(() -> Calculator.add(2,3), executor);

        /*bắt sự kiện tất cả các CompletableFuture hoàn thành thì ta dùng method allOf()*/
        CompletableFuture<Void> futureAll = CompletableFuture
                .allOf(f1, f2, f3)
                .thenRun(() -> {
                    System.out.println("All future is Done");
                });
//        futureAll.thenRunAsync(()->{
//
//        });
        System.out.println("Main End");
        executor.shutdown();
    }
}
