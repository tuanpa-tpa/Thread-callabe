package completableFuture;

public class Calculator {
    public static int add(int a, int b) {
        int sum = a + b;
        System.out.println("result: " + a + " + " + b + " = " + sum);
        return sum;
    }
}
