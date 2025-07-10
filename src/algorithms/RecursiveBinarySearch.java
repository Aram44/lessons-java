package algorithms;

public class RecursiveBinarySearch {

    public static void main(String[] args) {
        var array = new int[] {1, 2, 3, 4, 5, 7, 9, 11, 12, 14, 16, 17, 19, 20};
        System.out.println("Recursive Binary Search " + recBinSearch(array, 9, 0, array.length - 1));
        System.out.println("Recursive Binary Search " + recBinSearch(array, 13, 0, array.length - 1));
    }

    private static int recBinSearch(int[] array, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (array[mid] == target) {
            return mid;
        }
        if (array[mid] < target) {
            return recBinSearch(array, target, low, mid - 1);
        }
        return recBinSearch(array, target, mid + 1, high);
    }
}
