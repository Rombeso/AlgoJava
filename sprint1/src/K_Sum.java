import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class K_Sum {

    private static List<Integer> getSum(List<Integer> numberList, int k) {
//        // Ваше решение
// 1, не проходит по времени
//        StringBuilder str = new StringBuilder(k);
//        for (int num:numberList) {
//            str.append(num);
//        }
//        int firstNumber = Integer.parseInt(str.toString());
//        String resultNumber = String.valueOf(firstNumber + k);
//        List<Integer> resList = new ArrayList<>();
//        for(char ch:resultNumber.toCharArray()) {
//            resList.add(Character.getNumericValue(ch));
//        }
//        return resList;
////============================
// 2, не проходит по времени
//        Integer[] array = new Integer[numberList.size()];
//        numberList.toArray(array);
//        String arrayString = Arrays.toString(array);
//        String stringFormat = arrayString.replace(" ", "")
//                .replace("[", "")
//                .replace("]", "")
//                .replace(",", "");
//        int firstNumber = Integer.parseInt(stringFormat);
//        List<Integer> resList = new ArrayList<>();
//        String sum = Integer.toString(k + firstNumber);
//                for(char ch:sum.toCharArray()) {
//            resList.add(Character.getNumericValue(ch));
//        }
//        return resList;

        Collections.reverse(numberList);
        List<Integer> result = new ArrayList<>();
        int moveTo = k;

        for (int num : numberList) {
            int sum = num + moveTo;
            result.add(sum % 10);
            moveTo = sum / 10;
        }

        while (moveTo > 0) {
            result.add(moveTo % 10);
            moveTo /= 10;
        }

        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int numberLength = readInt(reader);
            List<Integer> numberList = readList(reader);
            int k = readInt(reader);
            List<Integer> sum = getSum(numberList, k);
            for (int elem : sum) {
                writer.write(elem + " ");
            }
        }
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}