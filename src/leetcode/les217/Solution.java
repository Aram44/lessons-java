package leetcode.les217;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        var res = containsDuplicate(new int[]{1, 2, 3});
        System.out.println("res is " + res);
    }

    public static boolean containsDuplicate(int[] nums) {
       return Arrays.stream(nums).boxed().collect(Collectors.toSet()).size() != nums.length;
    }
}
