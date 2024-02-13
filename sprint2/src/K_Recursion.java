import java.util.Scanner;

public class K_Recursion {
    public static int factorial(int n) {

        if (n == 0 || n == 1) {
            return 1;
        } else {
            return factorial(n - 1) + factorial(n - 2);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(factorial(n)); // Output: 120

    }
}
