package algorithms.leetcode.les567;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidboaoo"));
        System.out.println(checkInclusion("ab", "ab"));
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("hello", "ooolleoooleh"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) return false;
        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        String sortedS1 = new String(s1Arr);

        for (int i = 0; i < s2.length(); i++) {
            for (int j = i; j < s2.length(); j++) {
                char[] subStrArr = s2.substring(i, j + 1).toCharArray();
                Arrays.sort(subStrArr);
                String sortedSubStr = new String(subStrArr);

                if (sortedSubStr.equals(sortedS1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
