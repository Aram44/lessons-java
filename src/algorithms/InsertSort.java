package algorithms;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        var arr = new int[]{5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(sortedArr(arr)));
    }
    public static int[] sortedArr(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
