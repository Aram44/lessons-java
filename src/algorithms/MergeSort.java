package algorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        final int[] arr = {1, 8, 7, 9, 4, 3};
        System.out.println("Merge Sorted arr " + Arrays.toString(mergeSort(arr, 0, arr.length - 1)));
    }

    public static int[] mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            return merge(arr, left, mid, right);
        }
        return arr;
    }

    public static int[] merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) arr[k++] = leftArr[i++];
            else arr[k++] = rightArr[j++];
        }

        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
        return arr;
    }

}
