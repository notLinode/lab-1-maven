import java.util.HashSet;
import java.util.Set;

public class FibonacciSequence {

    private static FibonacciSequence instance;

    public static FibonacciSequence getInstance() {
        if (instance == null) {
            instance = new FibonacciSequence();
        }
        return instance;
    }

    private FibonacciSequence() {}

    private static Set<Integer> fib = new HashSet<>();
    private static int f0 = 1, f1 = 1, f2 = 0;

    public boolean contains(int num) {
        while (f2 < num) {
            f2 = f0 + f1;
            fib.add(f2);
            f0 = f1;
            f1 = f2;
        }

        return fib.contains(num);
    }

}