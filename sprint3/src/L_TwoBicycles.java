import java.io.*;
import java.util.Arrays;

public class L_TwoBicycles {

    public static int binarySearch(int[] days, int x, int left, int right) {
        if (right < left && left != 0) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (days[mid] >= x && (mid == 0 || days[mid - 1] < x)) {
            return mid + 1;
        } else if (x <= days[mid]) {
            return binarySearch(days, x, left, mid - 1);
        } else {
            return binarySearch(days, x, mid + 1, right);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        int[] savingPerDaysArray = readLineAsArray(reader);
        int costOfBicycle = Integer.parseInt(reader.readLine());
        int firstBike = binarySearch(savingPerDaysArray, costOfBicycle, 0, n - 1);
        int secondBike = binarySearch(savingPerDaysArray, costOfBicycle * 2, firstBike, n - 1);
        writer.write(firstBike+ " " + secondBike);
        writer.flush();
        reader.close();
    }

    private static int[] readLineAsArray(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
