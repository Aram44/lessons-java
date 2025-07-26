package leetcode.les15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return List.of();
        }
        List res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (i != j && j != k && j != k && sum == 0) {
                    var numsList = Arrays.asList(nums[i], nums[j], nums[k]);
                    if (!res.contains(numsList)) {
                        res.add(new ArrayList<>(numsList));
                    }
                }
                if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}
