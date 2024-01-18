import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {

    // Если ответ существует, верните список из двух элементов
    // Если нет - то верните пустой список
    private static List<Integer> twoSum(List<Integer> arr, int targetSum) {
        // Ваше решение
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (integerList.size() > 0){
                break;
            }
            for (int j = i + 1 ; j < arr.size(); j++) {
                int sum = arr.get(i) + arr.get(j);
                if (sum == targetSum) {
                    integerList.add(arr.get(i));
                    integerList.add(arr.get(j));
                    break;
                }
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
