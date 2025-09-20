package algorithms.leetcode.les13;

public class Solution {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));

    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        int len = nums.length;
        int diff = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < len - 2; i++) {
            for (int k = i + 2; k < len; k++) {
                int j = i + 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    var currentDiff = Math.abs(target - sum);
                    if (currentDiff < diff) {
                        diff = currentDiff;
                        res = sum;
                    }
                    j++;
                }
            }
        }
        return res;
    }
}
