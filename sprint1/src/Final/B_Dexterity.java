package Final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_Dexterity {
    private static int getPoints(String[] matrix, int amountButtons) {
        int max = 9;
        int res = 0;
        int lengthString = 4;
        int[] scoreArray = new int[max + 1];
        for (int i = 0; i < lengthString; i++) {
            char[] chars = matrix[i].toCharArray();
            for (int j = 0; j < lengthString; j++) {
                if (chars[j] == '.') {
                    continue;
                } else {
                    scoreArray[chars[j] - '0'] ++;
                }
            }
        }

        for (int element: scoreArray) {
            if (element <= amountButtons &&  element != 0) {res++;}
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int amountButtons = readInt(reader) * 2;
            String[] matrix = readMatrix(reader);
            int points = getPoints(matrix, amountButtons);
            System.out.print(points);
        }
    }


    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }


    private static String[] readMatrix(BufferedReader reader) throws IOException {
        String[] stringArr = new String[4];
        for (int i = 0; i < 4; i++) {
            stringArr[i] = reader.readLine();
        }
        return stringArr;
    }
}
