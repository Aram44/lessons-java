package leetcode.les78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static List<List<Integer>> res = new ArrayList<>();
    private static LinkedList<Integer> subset = new LinkedList<Integer>();
    private static int[] nums = new int[]{1, 2, 3};

    public static void main(String[] args) {
        subsets();
        System.out.println(res);
    }

    public static void subsets() {
        if (nums == null || nums.length == 0) {
            return;
        }
        dfs( 0);
    }

    private static void dfs(int index) {
        System.out.println(index);
        if (index >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        dfs(index + 1);
        subset.pollLast();
        dfs( index + 1);
    }
}
