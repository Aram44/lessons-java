package leetcode.les74;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 11));
        System.out.println(searchMatrix(new int[][]{{1}}, 1));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        var n = matrix.length;
        var m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            if (target <= matrix[i][m - 1]) {
                return Arrays.binarySearch(matrix[i], target) != -1;
            }
        }
        return false;
    }

    public static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0, rigth = nums.length, mid = -1;
        while (left < rigth) {
            mid = left + (rigth - left) / 2;
            int val = nums[mid];
            if (val == target) {
                return true;
            }
            if (val > target) {
                rigth = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
