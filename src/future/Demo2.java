package future;

import java.util.concurrent.*;

public class Demo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Calculator c1 = new Calculator(1, 2);
        Calculator c2 = new Calculator(2, 3);
        Calculator c3 = new Calculator(1, 3);

        /*tạo ra một thread pool chứa tối đa 10 thread chạy cùng lúc.*/
        ExecutorService executor = Executors.newFixedThreadPool(10);

        /*Future sẽ chứa kết quả phép tính tổng*/
        Future<Integer> f1 = executor.submit(c1);
        /* gọi f1.get() thì nó sẽ block thread chính lại để khi nào đối tượng c1 thực hiện xong và trả về kết quả.*/
        System.out.println(f1.get());
        Future<Integer> f2 = executor.submit(c2);
        /*nếu sau 1 giây mà chưa có kết quả thì không chờ nữa*/
        System.out.println(f2.get(1, TimeUnit.SECONDS));
        Future<Integer> f3 = executor.submit(c3);
        System.out.println("Main End");

        /*Thực hiện tắt executor ckhi không còn task (đối tượng  Callable) nào ở bên trong (các task đã hoàn thành).
        Nếu không có lệnh này thì chương trình của sẽ hạy mãi vì nó luôn có một thread kiểm tra task trong executor để thực thi.*/
        executor.shutdown();
    }
}
