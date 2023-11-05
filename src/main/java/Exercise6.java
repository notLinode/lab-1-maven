import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise6 implements Exercise {

    // 6. Ввести с консоли n целых чисел и поместить их в массив.
    // На консоль вывести числа принадлежащие ряду Фибоначчи:
    // f(0) = f(1) = 1, f(n) = f(n-1) + f(n-2).
    @Override public void solve(Scanner sc) {
        System.out.print("Введите n целых чисел через пробел:\n> ");
        Scanner nums = new Scanner(sc.nextLine());

        Set<Integer> fib = new HashSet<>();
        int f0 = 1, f1 = 1, f2 = 1;
        fib.add(1);

        System.out.println("Числа, принадлежащие ряду Фибоначчи:");
        while (nums.hasNextInt()) {
            int num = nums.nextInt();

            while (f2 < num) {
                f2 = f0 + f1;
                fib.add(f2);
                f0 = f1;
                f1 = f2;
            }

            if (fib.contains(num)) {
                System.out.println(num);
            }
        }

        System.out.println();
    }

}