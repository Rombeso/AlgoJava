package Sorts;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(5);
        array.add(2);
        array.add(4);
        array.add(6);
        array.add(1);
        array.add(3);
        bubbleSort(array);
    }

    public static void bubbleSort(List<Integer> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = 0; j < array.size() - 1 ; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    int value = array.get(j);
                    array.set(j, array.get(j+1));
                    array.set(j+1, value);
                }
            }
            System.out.println(array.toString());
        }
    }
}
