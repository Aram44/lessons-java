package leetcode.les242;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("ccac", "aacc"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.equals(t)) return true;
        StringBuilder sb = new StringBuilder(t);
        for (int i = 0; i < s.length(); i++) {
            var index = sb.indexOf(String.valueOf(s.charAt(i)));
            if (index != -1) {
                sb.deleteCharAt(index);
            }else {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        char temp1[]=s.toCharArray();
        char temp2[]=t.toCharArray();
        Arrays.sort(temp1);
        Arrays.sort(temp2);
        return Arrays.equals(temp1,temp2);
    }
}
