import java.util.Scanner;

public class Exercise7 implements Exercise {

    // 7. Ввести с консоли n целых чисел и поместить их в массив.
    // На консоль вывести числа-полиндромы, значения которых
    // в прямом и обратном порядке совпадают.
    @Override public void solve(Scanner sc) {
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

    private static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }

        return true;
    }

}