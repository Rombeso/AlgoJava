import java.util.Scanner;

public class I {

    private static int calcVariantBeTree(int num){
        if (num == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < num; i++) {
            int leftSubtree = calcVariantBeTree(i);
            int rightSubtree = calcVariantBeTree(num - i - 1);

            res += leftSubtree * rightSubtree;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers = Integer.parseInt(scanner.nextLine());
        System.out.println(calcVariantBeTree(numbers));
    }
}
