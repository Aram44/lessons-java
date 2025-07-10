package algorithms;

import java.util.Arrays;

public class QSort {

    public static void main(String[] args) {
        final int[] arr = {1, 8, 7, 9, 4, 3};
        System.out.println(Arrays.toString(qsort(arr)));
    }

    private static int[] qsort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int supportingElement = arr[arr.length - 1];
        int[] minElementsArray = new int[arr.length];
        int[] maxElementsArray = new int[arr.length];
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < supportingElement) {
                minElementsArray[minIndex++] = arr[i];
            } else if (arr[i] > supportingElement) {
                maxElementsArray[maxIndex++] = arr[i];
            }
        }
        int[] sortedMinElements = qsort(Arrays.copyOfRange(minElementsArray, 0, minIndex));
        int[] sortedMaxElements = qsort(Arrays.copyOfRange(maxElementsArray, 0, maxIndex));
        int[] sortedArray = new int[arr.length];
        int index = 0;
        for (int i = 0; i < sortedMinElements.length; i++) {
            sortedArray[index++] = sortedMinElements[i];
        }
        sortedArray[index++] = supportingElement;
        for (int i = 0; i < sortedMaxElements.length; i++) {
            sortedArray[index++] = sortedMaxElements[i];
        }
        return sortedArray;
    }
}
