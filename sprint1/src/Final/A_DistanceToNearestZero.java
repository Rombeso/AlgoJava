package Final;

import java.io.*;

public class A_DistanceToNearestZero {
    private static int[] getDistanceToNearestZero(String[] numberList, int sizeList) {
        int[] result = new int[sizeList];
        int count = sizeList;

        for (int i = 0; i < sizeList; i++) {
            if (numberList[i].equals("0")) {
                count = 0;
            } else {
                count++;
            }
            result[i] = count;
        }

        count = sizeList;

        for (int i = sizeList - 1; i >= 0; i--) {
            if (numberList[i].equals("0")) {
                count = 0;
            } else {
                count++;
            }
            result[i] = Math.min(result[i], count);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int numberLength = readInt(reader);
            String[] numberList = reader.readLine().split(" ");
            int[] result = getDistanceToNearestZero(numberList, numberLength);
            for (int elem : result) {
                writer.write(elem + " ");
            }
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}
