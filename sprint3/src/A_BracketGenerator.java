import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_BracketGenerator {

    static void generateBrackets(int n, int counterOpen, int counterClose, String prefix) {
        if (counterOpen + counterClose == 2 * n) {
            System.out.println(prefix);
            return;
        }
        if (counterOpen < n) {
            generateBrackets(n, counterOpen + 1, counterClose, prefix + "(");
        }
        if (counterOpen > counterClose) {
            generateBrackets(n, counterOpen, counterClose + 1, prefix + ")");
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        generateBrackets(n, 0, 0, "");
    }
}
