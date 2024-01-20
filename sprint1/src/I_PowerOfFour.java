import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class I_PowerOfFour {

    private static boolean isPowerOfFour(int n) {
        // Ваше решение
        List<Integer> array = new ArrayList<>();
        int result = 1;
        array.add(1);
        while (result <= 10000) {
            result = 4 * result;
            array.add(result);
        }
        return array.contains(n);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            if (isPowerOfFour(n)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }


    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

}