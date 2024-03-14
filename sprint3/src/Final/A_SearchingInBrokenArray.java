package Final;

public class A_SearchingInBrokenArray {

    public static int searchFirstElement(int[] arr, int left, int right) {
        // Your code
        // “ヽ(´▽｀)ノ”
        if (right <= left) {
            return left;
        }
        int mid = (left + right) / 2;
         if (arr[mid] < arr[right]) {
            return searchFirstElement(arr, left, mid);
        } else {
            return searchFirstElement(arr, mid + 1, right);
        }
    }
    public static int searchElement(int[] arr, int x, int left, int right, int mid) {

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[left] <= arr[mid]) {
                if (x >= arr[left] && x < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (x > arr[mid] && x <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int brokenSearch(int[] arr, int k) {
        // Your code
        // “ヽ(´▽｀)ノ”
        if (arr.length == 1) {
            return arr[0] == k ? 0 : -1;
        }
        int firstElement = searchFirstElement(arr, 0, arr.length - 1);
        int resultIndex = searchElement(arr, k,0, arr.length - 1, firstElement);
        return resultIndex;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 7, 9, 0};
        System.out.println(brokenSearch(arr, 3));
    }
}
