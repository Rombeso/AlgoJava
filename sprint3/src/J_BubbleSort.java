import java.io.*;
import java.util.Arrays;

public class J_BubbleSort {

    private static void bubbleSort(int[] array, int n) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean swapped;
        boolean arrayBeenSorted = true;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < array.length - 1 ; j++) {
                if (array[j] > array[j + 1]) {
                    int value = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = value;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            } else {
                printArray(array, writer);
                arrayBeenSorted = false;
            }
        }
        if (arrayBeenSorted) {
            printArray(array, writer);
        }
        writer.flush();
        writer.close();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] savingPerDaysArray = readLineAsArray(reader);
        bubbleSort(savingPerDaysArray, n);
        reader.close();
    }

    private static int[] readLineAsArray(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static void printArray(int[] array, BufferedWriter writer) throws IOException {
        for (int element : array) {
            writer.write(String.valueOf(element + " "));
        }
        writer.newLine();
    }
}
