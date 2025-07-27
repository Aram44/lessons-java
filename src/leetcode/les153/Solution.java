package leetcode.les153;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(findMin(new int[]{3, 4, 5, 6, 7, 8, 9, 1, 2}));
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
//        System.out.println(findMin(new int[]{1}));
//        System.out.println(findMin(new int[]{3, 1, 2}));
    }

    public static int findMin(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int i = 0, j = nums.length - 1;
        int mid = nums[0];
        int end = nums[nums.length - 1];
        while (i <= j) {
            mid = i + (j - i) / 2;
            System.out.println(i + " " + j + " " + mid);
            if (mid + 1 == j) {
                return nums[mid];
            }
            if (nums[mid] > end) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return nums[mid];
    }
}
