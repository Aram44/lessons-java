package algorithms.leetcode.les128;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(longestConsecutive(new int[]{0}));
        System.out.println(longestConsecutive(new int[]{0, -1}));
    }

    public static int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }
        for (int x : st) {
            if (st.contains(x - 1)) {
                continue;
            }
            int y = x + 1;
            while (st.contains(y)) {
                y++;
            }
            ans = Math.max(ans, y - x);
        }
        return ans;
    }

    public static int longestConsecutive2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0, curr = nums[0], streak = 0, i = 0;

        while (i < nums.length) {
            if (curr != nums[i]) {
                curr = nums[i];
                streak = 0;
            }
            while (i < nums.length && nums[i] == curr) {
                i++;
            }
            streak++;
            curr++;
            res = Math.max(res, streak);
        }
        return res;
    }
}
