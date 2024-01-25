package Final;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class A_DistanceToNearestZero {
    private static int[] getDistanceToNearestZero(String[] numberList, int sizeList) {
        // 1 вариант, не прошел по времени
//            int count = 1;
//            int beforeZero;
//            List<Integer> leftToRight = new ArrayList<>();
//            List<Integer> rightToLeft = new ArrayList<>();
//
//            beforeZero = numberList.get(0) != 0 ? sizeList : 0;
//            for (int number: numberList) {
//                if (number == 0) {
//                    leftToRight.add(0);
//                    count = 1;
//                    beforeZero = 0;
//                } else if (beforeZero == sizeList) {
//                    leftToRight.add(sizeList);
//                } else {
//                    leftToRight.add(count);
//                    count++;
//                }
//            }
//
//            Collections.reverse(numberList);
//            beforeZero = numberList.get(0) != 0 ? sizeList : 0;
//            for (int number: numberList) {
//                if (number == 0) {
//                    rightToLeft.add(0);
//                    count = 1;
//                    beforeZero = 0;
//                }else if (beforeZero == sizeList) {
//                    rightToLeft.add(sizeList);
//                } else {
//                    rightToLeft.add(count);
//                    count++;
//                }
//            }
//
//            Collections.reverse(rightToLeft);
//            numberList.clear();
//            for (int i = 0; i < sizeList; i++) {
//                int left = leftToRight.get(i);
//                int right = rightToLeft.get(i);
//                if (left < right) {
//                    numberList.add(left);
//                } else if (left > right) {
//                    numberList.add(right);
//                } else {
//                    numberList.add(left);
//                }
//            }
//            return numberList;

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
