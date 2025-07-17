package leetcode.les242;

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
}
