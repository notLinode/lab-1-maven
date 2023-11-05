import java.util.Scanner;

public class Exercise6 implements Exercise {

    // 6. Ввести с консоли n целых чисел и поместить их в массив.
    // На консоль вывести числа принадлежащие ряду Фибоначчи:
    // f(0) = f(1) = 1, f(n) = f(n-1) + f(n-2).
    @Override public void solve(Scanner sc) {
        System.out.print("Введите n целых чисел через пробел:\n> ");
        Scanner nums = new Scanner(sc.nextLine());

        System.out.println("Числа, принадлежащие ряду Фибоначчи:");
        while (nums.hasNextInt()) {
            int num = nums.nextInt();

            if (FibonacciSequence.getInstance().contains(num)) {
                System.out.println(num);
            }
        }

        System.out.println();
    }

}