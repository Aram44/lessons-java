package leetcode.algorithm;

import java.util.stream.Collectors;

public class SlicedWindow {
    public static void main(String[] args) {
        System.out.println("res for pwwkew " + lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        int res = 0;
        int i = 0;
        for (int j = 1; j <= s.length(); j++) {
            var sub = s.substring(i, j);
            var chars = sub.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
            if (chars.size() == sub.length() && chars.size() > res) {
                res = chars.size();
            }else {
                i++;
            }
        }
        return res;
    }
}
