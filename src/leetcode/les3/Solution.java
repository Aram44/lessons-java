package leetcode.les3;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        var res = lengthOfLongestSubstring("bbbbb");
        System.out.println("res is " + res);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int res = 1;
        for (int i = s.length(); i > 0; i--) {
            for (int j = 0; j < s.length() - i+1; j++) {
                var length = Math.min(i + j, s.length());
                var sub = s.substring(j, length);
                Set<Character> charSet = sub.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toSet());
                if (charSet.size() == sub.length()) {
                    return charSet.size();
                }
            }
        }
        return res;
    }

    //Optimise
    public static int lengthOfLongestSubstring1(String s) {

        int left = 0;
        int n = s.length();
        int max = 0;
        HashSet<Character> set = new HashSet<>();

        for(int right=0; right<n; right++){
            char curr = s.charAt(right);
            while(set.contains(curr)){
                set.remove(s.charAt(left++));
            }
            set.add(curr);
            max = Math.max(max, right-left+1);
        }

        return max;
    }
}
