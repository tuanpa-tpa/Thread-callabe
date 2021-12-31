package completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo2 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        CompletableFuture<Integer> f1 = CompletableFuture
                .supplyAsync(() -> Calculator.add(2, 10), executor);
        CompletableFuture<Integer> f2 = CompletableFuture
                .supplyAsync(() -> Calculator.add(5, 10), executor);
        CompletableFuture<Integer> f3 = CompletableFuture
                .supplyAsync(() -> Calculator.add(1, 10), executor);

        /*thực hiện làm gì khi CompletableFuture hoàn thành (không cần quan tâm kết quả là gì).*/
        f1.thenRun(() -> {
            System.out.println("f1 okokokok");
        });

        /*xử lý kết quả khi CompletableFuture hoàn thành.*/
        f2.thenAccept((data) -> {
            System.out.println("f2 result " + data);
        });

        /*dùng xử lý kết quả hoặc lỗi khi CompletableFuture  hoàn thành.*/
        f3.handle((data, ex) -> {
            if (ex != null) {
                System.out.println("f3 " + ex);
                return null;
            } else {
                System.out.println("f3 result " + data);
                return data;
            }
        });
        System.out.println("Main End");
        executor.shutdown();
    }
}
