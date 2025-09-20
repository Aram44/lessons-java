package algorithms.leetcode.les217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        var res = containsDuplicate(new int[]{1, 2, 3});
        System.out.println("res is " + res);
    }

    public static boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.toSet()).size() != nums.length;
    }

    public boolean containsDuplicateSimpl(int[] nums) {
        Set<Integer> checkNums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            var num = nums[i];
            if (checkNums.contains(num)) {
                return true;
            } else {
                checkNums.add(num);
            }
        }
        return false;
    }
}
