import java.io.*;
import java.util.Comparator;

public class H_BiggestNumber {
    static void insertion_sort_by_comparator(String[] array, Comparator<String> more) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < array.length; i++) {
            String item_to_insert = array[i];
            int j = i;

            while (j > 0 && more.compare(item_to_insert, array[j-1]) < 0) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = item_to_insert;
        }
        printArray(array, writer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] numbersArray = reader.readLine().split(" ");
        Comparator<String> reverseComparator = (n1, n2) -> (n2 + n1).compareTo(n1 + n2);
        insertion_sort_by_comparator(numbersArray, reverseComparator);
        reader.close();
    }

    public static void printArray(String[] array, BufferedWriter writer) throws IOException {
        for (String element : array) {
            writer.write(String.valueOf(element));
        }
        writer.newLine();
        writer.flush();
    }
}
