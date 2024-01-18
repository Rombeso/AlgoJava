import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {

    // Если ответ существует, верните список из двух элементов
    // Если нет - то верните пустой список
    private static List<Integer> twoSum(List<Integer> arr, int targetSum) {
        // Ваше решение
        List<Integer> integerList = new ArrayList<>();
        List<Integer> sortList = new ArrayList<>(arr);
        sortList.sort(null);
        int left = 0;
        int right = sortList.size() - 1;
        while (left < right) {
            int sum = sortList.get(left) + sortList.get(right);
            if (sum == targetSum) {
                integerList.add(sortList.get(left));
                integerList.add(sortList.get(right));
                break;
            } else if (sum > targetSum) {
                --right;
            } else {
                ++left;
            }
        }
    return integerList;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            List<Integer> arr = readList(reader);
            int targetSum = readInt(reader);
            List<Integer> result = twoSum(arr, targetSum);
            if (result.isEmpty()) {
                System.out.println("None");
            } else {
                System.out.println(result.get(0) + " " + result.get(1));
            }
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return  Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }

}
