import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class G_BinaryNumber {

    private static String getBinaryNumber(int n) {
        // Ваше решение
        if (n == 0) return "0";
        String binaryNumber = "";
        while (n >= 1) {
            binaryNumber += n % 2;
//            System.out.println(n % 2);
//            if (n % 2 != 0) {
//                binaryNumber += "1";
//            } else {
//                binaryNumber += "0";
//            }
            n = n / 2;
        }
        binaryNumber = new StringBuilder(binaryNumber).reverse().toString();
        return binaryNumber;
    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            System.out.println(getBinaryNumber(n));
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}
