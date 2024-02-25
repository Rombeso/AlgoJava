import java.io.*;
import java.util.Arrays;

public class G_CountingSort {
    public static void countingSort(int[] array, int k) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] countedValues = new int[k];
        for (int value : array) {
            countedValues[value]++;
        }

        int index = 0;
        for (int value = 0; value < k; value++) {
            for (int amount = 0; amount < countedValues[value]; amount++) {
                array[index] = value;
                index++;
            }
        }
        printArray(array, writer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n == 0) return;
        int[] numbersArray = readLineAsArray(reader);
        countingSort(numbersArray, 3);
        reader.close();
    }

    private static int[] readLineAsArray(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static void printArray(int[] array, BufferedWriter writer) throws IOException {
        for (Integer element : array) {
            writer.write(String.valueOf(element + " "));
        }
        writer.newLine();
        writer.flush();
    }
}
