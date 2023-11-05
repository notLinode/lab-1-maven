import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise4 implements Exercise {

    // 4. Создайте приложение, которое покажет, что для выражения a^n + b^n = c^n
    // (теорема Ферма) нет натуральных решений от 1 до 100 и n>2.
    // Убедитесь, что есть решения для n=2, и выведите их в консоль.
    @Override public void solve(Scanner sc) {
        System.out.print("Введите степень n от 2 до 127:\n> ");
        byte pow = sc.nextByte();
        if (pow < 2) {
            pow = 2;
        }

        List<BigInteger> possibleValues = new ArrayList<>(100);
        for (int i = 1; i <= 100; i++) {
            possibleValues.add(new BigInteger(Integer.toString(i)).pow(pow));
        }

        BigInteger a, b, c;

        System.out.printf("Ищем решение уравнения Ферма для степени %d:%n", pow);
        for (int i = 0; i < possibleValues.size(); i++) {
            a = possibleValues.get(i);
            for (int j = i; j < possibleValues.size(); j++) {
                b = possibleValues.get(j);

                c = a.add(b);

                if (possibleValues.contains(c)) {
                    System.out.printf("%d^%d + %d^%d = %d^%d%n", a.sqrt(), pow, b.sqrt(), pow, c.sqrt(), pow);
                }
            }
        }

        System.out.println();
    }

}