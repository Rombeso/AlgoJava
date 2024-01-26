package Final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_Dexterity {
    private static int getPoints(String matrix, int amountButtons) {
        if (matrix.isEmpty()) {return 0;}
        int res = 0;
        int count = 0;
        char[] chars = matrix.toCharArray();
        Arrays.sort(chars);
        int currentNumber = chars[0] - '0';
        for (int i = 0; i < chars.length; i++) {
            if (currentNumber == chars[i] - '0') {
                count++;
            } else {
                if(count > 0 && count <= amountButtons) {
                    res++;
                }
                currentNumber = chars[i] - '0';
                count = 1;
            }
            if (i == chars.length - 1 && count <= amountButtons) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int amountButtons = readInt(reader) * 2;
            String matrix = readMatrix(reader);
            int points = getPoints(matrix, amountButtons);
            System.out.print(points);
        }
    }


    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }


    private static String readMatrix(BufferedReader reader) throws IOException {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            string.append(reader.readLine().replaceAll("\\.", ""));
        }
        return string.toString();
    }
}
