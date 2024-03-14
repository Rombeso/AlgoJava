package Final;

import java.io.*;
import java.util.StringTokenizer;

public class B_EfficientQuickSorting {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        Participant[] array = new Participant[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String name = tokenizer.nextToken();
            int tasks = Integer.parseInt(tokenizer.nextToken());
            int penalPoints = Integer.parseInt(tokenizer.nextToken());
            array[i] = new Participant(name, tasks, penalPoints);
        }
        quickSort(array, 0, n - 1);
        for (Participant p : array) {
            writer.write(p.name);
            writer.newLine();
        }
        reader.close();
        writer.flush();
        writer.close();
    }

    private static void quickSort(Participant[] array, int left, int right) {
        if (left < right) {
            int center = inPlace(array, left, right);

            quickSort(array, left, center);
            quickSort(array, center + 1, right);
        }
    }

    private static int inPlace(Participant[] array, int left, int right) {
        int mid = (left + right) / 2;
        Participant pivot = array[mid];
        int i = left;
        int j = right;
        while (i <= j) {
            while (array[i].compareTo(pivot) < 0) {
                i++;
            }
            while (array[j].compareTo(pivot) > 0) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(array, i, j);
            i++;
            j--;
        }
        return j;
    }

    private static void swap(Participant[] array, int a, int b) {
        Participant temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

