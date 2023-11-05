import java.util.Scanner;

public class Exercise5 implements Exercise {

    // 5. Ввести с консоли n. Вычислить выражение
    // n - n/2 + n/3 - n/4 + ... + n/9999 - n/10000.
    @Override public void solve(Scanner sc) {
        System.out.print("Введите число n:\n> ");
        int n = sc.nextInt();

        double sum = 0;
        boolean nextIsNegative = true;
        for (int i = 1; i <= 10_000; i++) {
            sum += nextIsNegative ? -(double)n / (double)i : (double)n / (double)i;
            nextIsNegative = !nextIsNegative;
        }

        System.out.printf("%d - %d/2 + %d/3 - %d/4 + ... + %d/9999 - %d/10000 = %f\n\n", n, n, n, n, n, n, sum);
    }

}