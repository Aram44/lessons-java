package algorithms;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        final int[] arr = {1, 8, 7, 9, 4, 3};
        System.out.println("Insertion Sorted arr " + Arrays.toString(insertionSort(arr)));
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
        return arr;
    }

}
