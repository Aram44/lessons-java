package algorithms.leetcode.les17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static List<String> res = new ArrayList<>();
    private static String[] digitToChar = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public static void main(String[] args) {
       System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        backtrack(0, "", digits);
        return res;
    }

    private static void backtrack(int i, String curStr, String digits) {
        if (curStr.length() == digits.length()) {
            res.add(curStr);
            return;
        }
        String chars = digitToChar[digits.charAt(i) - '0'];
        for (char c : chars.toCharArray()) {
            backtrack(i + 1, curStr + c, digits);
        }
    }
}
