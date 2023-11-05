import java.util.Scanner;

public class Exercise3 implements Exercise {

    // 3. Для произвольной цифры от 0 до 9 вывести на консоль ее значение
    // прописью. Например, для цифры 9 на консоли должна быть напечатана
    // строка «девять».
    @Override public void solve(Scanner sc) {
        System.out.print("Введите цифру от 0 до 9:\n> ");
        int input = sc.nextInt();

        // Понимаю, что по правилам нужно создать enum, но для такого одиночного случая можно и так
        String[] digitToWord = { "ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять" };

        if (input >= 0 && input <= 9) {
            System.out.printf("%d в прописи будет \"%s\"\n\n", input, digitToWord[input]);
        }
        else {
            System.out.println("Это не цифра\n");
        }
    }

}