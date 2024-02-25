import java.util.Arrays;

public class K_MergeSort {
    public static int[] merge(int[] arr, int left, int mid, int right) {
        int arr1 = mid - left;
        int arr2 = right - mid;
        int[] leftArray = new int[arr1];
        int[] rightArray = new int[arr2];

        for (int i = 0; i < arr1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < arr2; j++) {
            rightArray[j] = arr[mid + j];
        }
        int l = 0, r = 0, k = left;
        while (l < arr1 && r < arr2) {
            if (leftArray[l] <= rightArray[r]) {
                arr[k++] = leftArray[l++];
            } else {
                arr[k++] = rightArray[r++];
            }
        }
        while (l < arr1) {
            arr[k++] = leftArray[l++];
        }

        while (r < arr2) {
            arr[k++] = rightArray[r++];
        }

        return arr;
    }

    public static void merge_sort(int[] arr, int left, int right) {
        if (left < right - 1) {
            int mid = (left + right) / 2;
            merge_sort(arr, left, mid);
            merge_sort(arr, mid, right);
            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 9, 2, 10, 11};
        int[] b = merge(a, 0, 3, 6);
        int[] expected = {1, 2, 4, 9, 10, 11};
        assert Arrays.equals(b, expected);
        int[] c = {1, 4, 2, 10, 1, 2};
        merge_sort(c, 0, 6);
        int[] expected2 = {1, 1, 2, 2, 4, 10};
        assert Arrays.equals(c, expected2);
        int[] d = {-6, -12, -14, 14};
        merge_sort(d, 0, d.length);
        System.out.println(Arrays.toString(d));
        int[] e = {18, -19, 15, -8, 14, 6, -6, 8, 17};
        merge_sort(e, 0, e.length);
        System.out.println(Arrays.toString(e));

    }
}
