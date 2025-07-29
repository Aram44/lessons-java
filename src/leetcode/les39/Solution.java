package leetcode.les39;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        combinationSum(new int[]{2,3,6,7}, 7);
        combinationSum(new int[]{2}, 1);
        combinationSum(new int[]{2,3,5}, 8);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(candidates, target, subset, 0, res);
        System.out.println(res);
        return res;
    }

    public static void backtrack(int[] nums, int target, List subset, int i, List res){
        if (target == 0) {
            res.add(new ArrayList(subset));
            return;
        }
        if (target < 0 || i >= nums.length) {
            return;
        }

        subset.add(nums[i]);
        backtrack(nums, target - nums[i], subset, i, res);
        subset.remove(subset.size() - 1);
        backtrack(nums, target, subset, i + 1, res);
    }
}
