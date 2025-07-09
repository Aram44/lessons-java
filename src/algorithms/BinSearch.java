package algorithms;

import java.util.List;

public class BinSearch {

    public static void main(String[] args) {
        List list = List.of(1, 2, 3, 4, 5, 7, 9, 11, 12, 14, 16, 17, 19, 20);
        System.out.println(binSearch(list, 5));
        System.out.println(binSearch(list, 13));
    }

    private static int binSearch(List list, int target) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = (int) list.get(mid);
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
