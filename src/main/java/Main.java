import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Стоило ли мне дать им нормальные имена?..
        Exercise ex1 = new Exercise1();
        Exercise ex2 = new Exercise2();
        Exercise ex3 = new Exercise3();
        Exercise ex4 = new Exercise4();
        Exercise ex5 = new Exercise5();
        Exercise ex6 = new Exercise6();
        Exercise ex7 = new Exercise7();
        Exercise ex8 = new Exercise8();
        Exercise ex9 = new Exercise9();

        System.out.print("Введите номер задания 1-9 (0 для выхода):\n> ");

        for (int input = sc.nextInt(); input != 0; input = sc.nextInt()) {
            sc.nextLine();

            switch (input) {
                case 1:
                    ex1.solve(sc);
                    break;

                case 2:
                    ex2.solve(sc);
                    break;

                case 3:
                    ex3.solve(sc);
                    break;

                case 4:
                    ex4.solve(sc);
                    break;

                case 5:
                    ex5.solve(sc);
                    break;

                case 6:
                    ex6.solve(sc);
                    break;

                case 7:
                    ex7.solve(sc);
                    break;

                case 8:
                    ex8.solve(sc);
                    break;

                case 9:
                    ex9.solve(sc);
                    break;

                default:
                    break;
            }

            System.out.print("Введите номер задания 1-9 (0 для выхода):\n> ");
        }
    }

}