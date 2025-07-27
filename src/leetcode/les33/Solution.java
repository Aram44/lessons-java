package leetcode.les33;

public class Solution {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{3, 5, 1}, 3));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
    }

    public static int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1, mid = -1;
        while (i <= j) {
            mid = (i + j) / 2;
            i = Math.min(i, mid);
            System.out.println(i + " " + j + " " + nums[i] + " " + nums[j] + " " + nums[mid]);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[i] == target) {
                return i;
            }
            if (nums[j] == target) {
                return j;
            }
            if (nums[mid] >= nums[j]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -1;
    }
}
