import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class H_SumOfBinaries {
    private static String sumOfBinaries(String a, String b) {
        // Ваше решение
        int length = a.length() >= b.length() ? a.length() : b.length();
        StringBuilder newA = new StringBuilder(a).reverse();
        StringBuilder newB = new StringBuilder(b).reverse();
        StringBuilder builder = new StringBuilder("");
        int tempNumber = 0;
        for (int i = 0; i < length; i++) {
            int sum = Character.getNumericValue(a.length() - 1 >= i ? newA.charAt(i) : '0')
                    + Character.getNumericValue(b.length() - 1 >= i ? newB.charAt(i) : '0');
            if (sum == 0) {
                if (tempNumber == 0) {
                    builder.append(0);
                } else {
                    builder.append(1);
                    tempNumber = 0;
                }
            } else if (sum == 1) {
                if (tempNumber == 0) {
                    builder.append(1);
                } else {
                    builder.append(0);
                    tempNumber = 1;
                }
            } else {
                if (tempNumber == 0) {
                    builder.append(0);
                    tempNumber = 1;
                } else {
                    builder.append(1);
                    tempNumber = 1;
                }
            }
        }
        if (tempNumber == 1) {
            builder.append(1);
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String a = reader.readLine();
            String b = reader.readLine();
            System.out.println(sumOfBinaries(a, b));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
