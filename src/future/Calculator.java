package future;

import java.util.concurrent.Callable;

public class Calculator implements Callable<Integer> {
    private int a;
    private int b;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int sum() {
        int sum = this.a + this.b;
        System.out.println("result: " + a + " + " + b + " = " + sum);
        return sum;
    }

    @Override
    public Integer call() throws Exception {
        return this.sum();
    }
}
