package leetcode.les46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(permuteV2(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return Arrays.asList(new ArrayList<>());
        }
        List<List<Integer>> perms = permute(Arrays.copyOfRange(nums, 1, nums.length));
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> p : perms) {
            for (int i = 0; i <= p.size(); i++) {
                List<Integer> p_copy = new ArrayList<>(p);
                p_copy.add(i, nums[0]);
                res.add(p_copy);
            }
        }
        return res;
    }

    public static List<List<Integer>> permuteV2(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        List<List<Integer>> main = new ArrayList<>();
        int[] used = new int[nums.length];
        permutation(nums, list, main, used);
        return main;
    }

    private static void permutation(int[] nums, ArrayList<Integer> list, List<List<Integer>> main, int[] used) {
        if (list.size() == nums.length) {
            main.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 0) {
                list.add(nums[i]);
                used[i] = 1;
                permutation(nums, list, main, used);

                list.remove(list.size() - 1);
                used[i] = 0;
            }
        }
    }
}
