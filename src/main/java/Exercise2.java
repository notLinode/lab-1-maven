import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise2 implements Exercise {

    // 2. Ввести с консоли n целых чисел и поместить их в массив.
    // На консоль вывести "счастливые" числа.
    @Override public void solve(Scanner sc) {
        System.out.print("Введите n целых чисел через пробел:\n> ");
        Scanner nums = new Scanner(sc.nextLine());

        System.out.print("Счастливые числа: ");
        while (nums.hasNextInt()) {
            int num = nums.nextInt();
            if (isHappy(num)) {
                System.out.printf("%d ", num);
            }
        }

        System.out.println('\n');
    }

    static boolean isHappy(int num) {
        Set<Integer> seenNums = new HashSet<>();

        while (num > 1 && !seenNums.contains(num)) {
            seenNums.add(num);

            int sumOfSquaresOfDigits = 0;
            while (num > 0) {
                int digit = num % 10;
                sumOfSquaresOfDigits += digit * digit;
                num = num / 10;
            }

            num = sumOfSquaresOfDigits;
        }

        return num == 1;
    }

}