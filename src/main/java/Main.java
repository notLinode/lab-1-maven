import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Exercise ex1 = new Exercise1();
        Exercise ex2 = new Exercise2();
        Exercise ex3 = new Exercise3();
        Exercise ex4 = new Exercise4();
        Exercise ex5 = new Exercise5();
        Exercise ex6 = new Exercise6();
        Exercise ex7 = new Exercise7();
        Exercise ex8 = new Exercise8();
        Exercise ex9 = new Exercise9();

        List<Exercise> exList = List.of( ex1, ex2, ex3, ex4, ex5, ex6, ex7, ex8, ex9 );
        exList.forEach(ex -> ex.solve(sc));
    }

}