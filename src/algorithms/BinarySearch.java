package algorithms;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        final int[] array = {7, 8, 4, 50, 12, 57, 88, 44};
        Arrays.sort(array);
        final int target = 12;
        System.out.println("The index is: " + findUsingBinarySearch(array, target));
    }

    public static int findUsingBinarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < array[mid]) {
                high = mid - 1;
            }else if (target > array[mid]) {
                low = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
