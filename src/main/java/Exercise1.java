import java.util.Scanner;

public class Exercise1 implements Exercise {

    // 1. Ввести с консоли n целых чисел и поместить их в массив.
    // На консоль вывести простые числа.
    @Override public void solve(Scanner sc) {
        System.out.print("Введите n целых чисел через пробел:\n> ");
        Scanner nums = new Scanner(sc.nextLine());

        System.out.print("Простые числа: ");
        while (nums.hasNextInt()) {
            int num = nums.nextInt();
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }

        System.out.println('\n');
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;

        for (int i = 2; i <= (int)Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

}