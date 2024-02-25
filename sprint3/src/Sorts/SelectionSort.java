package Sorts;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(5);
        array.add(2);
        array.add(4);
        array.add(6);
        array.add(1);
        array.add(3);
        insertionSort(array);
    }

    public static void insertionSort(List<Integer> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(minPosition) > array.get(j)) {
                    minPosition = j;
                }
            }
            int minValue = array.get(minPosition);
            array.set(minPosition, array.get(i));
            array.set(i, minValue);
            System.out.printf("step %d, sorted %d elements: %s\n", i, i + 1, array.subList(0, i + 1));
        }
    }
}
