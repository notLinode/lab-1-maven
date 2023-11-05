import java.util.Scanner;

public class Exercise8 implements Exercise {

    // 8. Ввести с консоли t целых чисел и поместить их в массив.
    // На консоль вывести дробную часть десятичной дроби р = m/n для
    // первых двух целых положительных чисел n и m, расположенных подряд.
    @Override public void solve(Scanner sc) {
        System.out.print("Введите t целых чисел через пробел:\n> ");
        Scanner nums = new Scanner(sc.nextLine());

        int num0 = nums.nextInt(); // num0 и num1 - первые два положительные
        int num1;                  // числа, расположенные подряд
        while (nums.hasNextInt()) {
            num1 = nums.nextInt();

            if (num0 > 0 && num1 > 0) {
                double division = (double)num1 / (double)num0;
                String fraction = Double.toString(division).split("\\.")[1]; // Дробная часть десятичной дроби
                System.out.printf("Дробная часть от деления %d на %d равна %s\n", num1, num0, fraction);
                return;
            }

            num0 = num1;
        }

        System.out.println();
    }

}