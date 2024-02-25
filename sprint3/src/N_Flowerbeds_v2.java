import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class N_Flowerbeds_v2 {

    public static int[][] sortArrays(int[][] array) {
        if (array.length == 1) {  // базовый случай рекурсии
            return array;
        }

        int[][] left = sortArrays(Arrays.copyOfRange(array, 0, array.length/2));
        int[][] right = sortArrays(Arrays.copyOfRange(array, array.length/2, array.length));

        int[][] result = new int[array.length][2];

        int l = 0, r = 0, k = 0;
        while (l < left.length && r < right.length) {

            if (left[l][0] <= right[r][0]) {
                result[k] = left[l];
                l++;
            } else {
                result[k] = right[r];
                r++;
            }
            k++;
        }

        while (l < left.length) {
            result[k] = left[l];
            l++;
            k++;
        }
        while (r < right.length) {
            result[k] = right[r];
            r++;
            k++;
        }
        return result;
    }
    public static void combine(int[][] array) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<int[]> flowerbed = new HashSet<>();
        for (int[] current : array) {
            boolean merged = false;
            for (int[] segment : flowerbed) {
                if ((segment[0] <= current[1]) && (segment[1] >= current[0])) {
                    segment[0] = Math.min(segment[0], current[0]);
                    segment[1] = Math.max(segment[1], current[1]);
                    merged = true;
                    break;
                }
            }
            if (!merged) {
                flowerbed.add(current);
            }
        }

        int[][] flowerbedArray = flowerbed.toArray(new int[0][]);
        Arrays.sort(flowerbedArray, Comparator.comparingInt(a -> a[0]));
        printArray(flowerbedArray, writer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[][] numbersArray = new int[n][2];
        for (int i = 0; i < n; i++) {
            numbersArray[i] = readLineAsArray(reader);
        }
        int[][] result = sortArrays(numbersArray);
        combine(result);
        reader.close();
    }

    public static void printArray(int[][] array, BufferedWriter writer) throws IOException {
        for (int[] element : array) {
            writer.write(String.join(" ", String.valueOf(element[0]), String.valueOf(element[1])));
            writer.newLine();
        }
        writer.flush();
    }

    private static int[] readLineAsArray(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
