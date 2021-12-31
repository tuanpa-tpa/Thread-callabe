package future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo1 {
    public static void main(String[] args) {
        Calculator c1 = new Calculator(1, 2);
        Calculator c2 = new Calculator(2, 3);
        Calculator c3 = new Calculator(1, 3);

        /*tạo ra một thread pool chứa tối đa 10 thread chạy cùng lúc.*/
        ExecutorService executor = Executors.newFixedThreadPool(10);

        /*Future sẽ chứa kết quả phép tính tổng*/
        Future<Integer> f1 = executor.submit(c1);
        Future<Integer> f2 = executor.submit(c2);
        Future<Integer> f3 = executor.submit(c3);
        System.out.println("Main End");

        /*Thực hiện tắt executor khi không còn task (đối tượng  Callable) nào ở bên trong (các task đã hoàn thành).
        Nếu không có lệnh này thì chương trình của sẽ chạy mãi vì nó luôn có một thread kiểm tra task trong executor để thực thi.*/
        executor.shutdown();
    }
}
