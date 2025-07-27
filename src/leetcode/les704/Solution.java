package leetcode.les704;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    public static int searchV2(int[] nums, int target) {
        return Arrays.binarySearch(nums, target);
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, rigth = nums.length - 1, mid = -1;
        while (left < rigth) {
            mid = left + (rigth - left) / 2;
            int val = nums[mid];
            if (val == target) {
                return mid;
            }
            if (val > target) {
                rigth = mid;
            } else {
                left = mid;
            }
        }
        return -1;
    }
}
