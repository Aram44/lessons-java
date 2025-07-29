package leetcode.les40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static Set<List<Integer>> res;

    public static void main(String[] args) {
        combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null) {
            return List.of();
        }
        Arrays.sort(candidates);
        res = new HashSet<>();
        var current = new ArrayList<>();
        recurse(0, target, current, candidates, 0);
        System.out.println(res);
        return new ArrayList(res);
    }

    private static void recurse(int i, int target, List current, int[] nums, int sum) {
        if(sum == target){
            List<Integer> k = new ArrayList<>(current);
            if (!res.contains(k)){ res.add(k); }
            return;
        }
        if(i >= nums.length || sum > target){
            return;
        }
        for(int j = i; j < nums.length ; j++){
            if (j > i && nums[j] == nums[j - 1]) continue;
            if(sum+nums[j] > target){ break; }
            current.add(nums[j]);
            recurse(j+1, target, current, nums, sum + nums[j]);
            current.removeLast();
        }
    }
}
