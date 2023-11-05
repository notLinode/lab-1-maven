import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.math.BigInteger;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Введите номер задания 1-9 (0 для выхода):\n> ");

        for (int input = sc.nextInt(); input != 0; input = sc.nextInt()) {
            sc.nextLine();
        /*
        В Java 17 можно заменить на 
            case 1 -> ex1();
            case 2 -> ex2();
            case 3 -> ex3();
            ...
        */
            switch (input) {
                case 1:
                    ex1();
                    break;

                case 2:
                    ex2();
                    break;

                case 3:
                    ex3();
                    break;

                case 4:
                    ex4();
                    break;

                case 5:
                    ex5();
                    break;

                case 6:
                    ex6();
                    break;

                case 7:
                    ex7();
                    break;

                case 8:
                    ex8();
                    break;

                case 9:
                    ex9();
                    break;

                default:
                    break;
            }

            System.out.print("Введите номер задания 1-9 (0 для выхода):\n> ");
        }
    }

    // 1. Ввести с консоли n целых чисел и поместить их в массив.
    // На консоль вывести простые числа.
    static void ex1() {
        System.out.print("Введите n целых чисел через пробел:\n> ");
        Scanner nums = new Scanner(sc.nextLine());

        System.out.print("Простые числа: ");
        while (nums.hasNextInt()) {
            int num = nums.nextInt();
            if (isPrime(num)) System.out.print(num + " "); // Желательно всегда использовать {} даже для однострочного оператора
        }

        System.out.println('\n'); // Тут 2 переноса нужен? 
    }

    static boolean isPrime(int num) {
        if (num <= 1) return false;

        for (int i = 2; i <= (int)Math.sqrt(num); i++)
            if (num % i == 0) return false;

        return true;
    }

    // 2. Ввести с консоли n целых чисел и поместить их в массив.
    // На консоль вывести "счастливые" числа.
    static void ex2() {
        System.out.print("Введите n целых чисел через пробел:\n> ");
        Scanner nums = new Scanner(sc.nextLine());

        System.out.print("Счастливые числа: ");
        while (nums.hasNextInt()) {
            int num = nums.nextInt();
            if (isHappy(num)) System.out.print(num + " ");
        }

        System.out.println('\n');
    }

    static boolean isHappy(int num) {
        HashSet<Integer> seenNums = new HashSet<>(); // Set<Integer> seenNums = new HashSet<>(), это часть принципа LSP

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

    // 3. Для произвольной цифры от 0 до 9 вывести на консоль ее значение
    // прописью. Например, для цифры 9 на консоли должна быть напечатана
    // строка «девять».
    static void ex3() {
        System.out.print("Введите цифру от 0 до 9:\n> ");
        int input = sc.nextInt();
        // Отступы, не лепим код в кучу
        switch (input) { // Можно упросить как в main
            case 0:
                System.out.println("0 в прописи будет \"ноль\"\n"); // Кст можно закатать в enum и упросить сильно код
                break;

            case 1:
                System.out.println("1 в прописи будет \"один\"\n");
                break;

            case 2:
                System.out.println("2 в прописи будет \"два\"\n");
                break;

            case 3:
                System.out.println("3 в прописи будет \"три\"\n");
                break;

            case 4:
                System.out.println("4 в прописи будет \"четыре\"\n");
                break;

            case 5:
                System.out.println("5 в прописи будет \"пять\"\n");
                break;

            case 6:
                System.out.println("0 в прописи будет \"шесть\"\n");
                break;

            case 7:
                System.out.println("7 в прописи будет \"семь\"\n");
                break;

            case 8:
                System.out.println("8 в прописи будет \"восемь\"\n");
                break;

            case 9:
                System.out.println("9 в прописи будет \"девять\"\n");
                break;

            default:
                System.out.println("Это не цифра\n");
                break;
        }
    }

    // 4. Создайте приложение, которое покажет, что для выражения a^n + b^n = c^n
    // (теорема Ферма) нет натуральных решений от 1 до 100 и n>2.
    // Убедитесь, что есть решения для n=2, и выведите их в консоль.
    static void ex4() {
        System.out.print("Введите степень n от 2 до 127:\n> ");
        byte pow = sc.nextByte();
        if (pow < 2) pow = 2;

        ArrayList<BigInteger> possibleValues = new ArrayList<>(100); // List<BigInteger> possibleValues = new ArrayList<>(100)
        for (int i = 1; i <= 100; i++) {
            possibleValues.add(new BigInteger(i+"").pow(pow)); // Или используем Integer.toString() или BigInteger.valueOf(),
        }                                                      // меняя int i на long i

        BigInteger a, b, c;

        System.out.printf("Ищем решение уравнения Ферма для степени %d:%n", pow);
        for (int i = 0; i < possibleValues.size(); i++) {
            a = possibleValues.get(i);
            for (int j = i; j < possibleValues.size(); j++) {
                b = possibleValues.get(j);

                c = a.add(b);

                if (possibleValues.contains(c))
                    System.out.printf("%d^%d + %d^%d = %d^%d%n",
                            a.sqrt(), pow, b.sqrt(), pow, c.sqrt(), pow);
            }
        }

        System.out.println();
    }

    // 5. Ввести с консоли n. Вычислить выражение
    // n - n/2 + n/3 - n/4 + ... + n/9999 - n/10000.
    static void ex5() {
        System.out.print("Введите число n:\n> ");
        int n = sc.nextInt();

        double sum = 0;
        boolean nextIsNegative = true;
        for (int i = 1; i <= 10_000; i++) {
            sum += nextIsNegative ? -(double)n / (double)i : (double)n / (double)i;
            nextIsNegative = !nextIsNegative;
        }

        System.out.printf("%d - %d/2 + %d/3 - %d/4 + ... + %d/9999 - %d/10000 = %f\n\n",
                n, n, n, n, n, n, sum);
    }

    // 6. Ввести с консоли n целых чисел и поместить их в массив.
    // На консоль вывести числа принадлежащие ряду Фибоначчи:
    // f(0) = f(1) = 1, f(n) = f(n-1) + f(n-2).
    static void ex6() {
        System.out.print("Введите n целых чисел через пробел:\n> ");
        Scanner nums = new Scanner(sc.nextLine());

        HashSet<Integer> fib = new HashSet<>(); // Set<Integer> fib = new HashSet<>()
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

            if (fib.contains(num))
                System.out.println(num);
        }

        System.out.println();
    }

    // 7. Ввести с консоли n целых чисел и поместить их в массив.
    // На консоль вывести числа-полиндромы, значения которых
    // в прямом и обратном порядке совпадают.
    static void ex7() {
        System.out.print("Введите n целых чисел через пробел:\n> ");
        Scanner nums = new Scanner(sc.nextLine());

        System.out.println("Числа-палиндромы:");
        while (nums.hasNext()) {
            String num = nums.next();
            if (isPalindrome(num))
                System.out.println(num);
        }

        System.out.println();
    }

    static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j)
            if (str.charAt(i++) != str.charAt(j--))
                return false;

        return true;
    }

    // 8. Ввести с консоли t целых чисел и поместить их в массив.
    // На консоль вывести дробную часть десятичной дроби р = m/n для
    // первых двух целых положительных чисел n и m, расположенных подряд.
    static void ex8() {
        System.out.print("Введите t целых чисел через пробел:\n> ");
        Scanner nums = new Scanner(sc.nextLine());

        int num0 = nums.nextInt(), num1; // Так лучше объявления не писать 
        while (nums.hasNextInt()) {
            num1 = nums.nextInt(); // Нужны метоимена, че за num0 и num1?

            if (num0 > 0 && num1 > 0) {
                System.out.println(
                        String.format("%f", (double)num1 / (double)num0).split(",")[1] // Надо рефакторить
                );
                return;
            }

            num0 = num1;
        }

        System.out.println();
    }

    // 9. Ввести с консоли n целых чисел и поместить их в массив.
    // Построить треугольник Паскаля для первого положительного числа.
    static void ex9() {
        System.out.print("Введите n целых чисел через пробел:\n> ");
        Scanner nums = new Scanner(sc.nextLine());

        int num = 0; // Первое положительное число
        while (nums.hasNextInt()) {
            num = nums.nextInt();
            if (num > 0) break;
        }
        if (num <= 0) return;

        System.out.println("Треугольник Паскаля для " + num + ":"); // String.format()
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                int pascalsTriangleNum = num;
                for (int k = 0; k < j; k++)
                    pascalsTriangleNum = pascalsTriangleNum * (i - k) / (k + 1);

                System.out.print(pascalsTriangleNum + " "); // String.format()
            }

            System.out.println();
        }

        System.out.println();
    }

}