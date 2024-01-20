import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class J_Factorize {

    private static List<Integer> factorize(int n) {
        // Ваше решение
        List<Integer> result = new ArrayList<>();
        if (n <= 1) {
            result.add(n);
            return result;
        }
        boolean isNotSimple = true;
        while (isNotSimple) {
            isNotSimple = false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    result.add(i);
                    n = n / i;
                    isNotSimple = true;
                    break;
                }
            }
            if (!isNotSimple) {
                result.add(n);
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = readInt(reader);
            List<Integer> factorization = factorize(n);
            for (int elem : factorization) {
                writer.write(elem + " ");
            }
        }
    }


    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}

