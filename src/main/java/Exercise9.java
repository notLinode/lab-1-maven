import java.util.Scanner;

public class Exercise9 implements Exercise {

    // 9. Ввести с консоли n целых чисел и поместить их в массив.
    // Построить треугольник Паскаля для первого положительного числа.
    @Override public void solve(Scanner sc) {
        System.out.print("Введите n целых чисел через пробел:\n> ");
        Scanner nums = new Scanner(sc.nextLine());

        int num = 0; // Первое положительное число
        while (nums.hasNextInt()) {
            num = nums.nextInt();
            if (num > 0) {
                break;
            }
        }
        if (num <= 0) {
            return;
        }

        System.out.printf("Треугольник Паскаля для %d:\n", num);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                int pascalsTriangleNum = num;
                for (int k = 0; k < j; k++) {
                    pascalsTriangleNum = pascalsTriangleNum * (i - k) / (k + 1);
                }

                System.out.printf("%d ", pascalsTriangleNum);
            }

            System.out.println();
        }

        System.out.println();
    }

}