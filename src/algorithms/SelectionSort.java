package algorithms;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        final int[] arr = {1, 8, 7, 9, 4, 3};
        System.out.println("Selection Sorted arr " + Arrays.toString(selectionSort(arr)));
    }

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // Swap smallest with current element
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }

}
