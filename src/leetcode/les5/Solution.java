package leetcode.les5;

class Solution {
    public static void main(String[] args) {
        System.out.println("Res = " + longestPalindrome("babad"));
        System.out.println("Res = " + longestPalindrome("cbbd"));
        System.out.println("Res = " + longestPalindrome("bb"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        String res = "";
        for (int left = 0; left < s.length(); left++) {
            for (int right = s.length(); right > left; right--) {
                System.out.println("left: " + left + " right: " + right);
                var sub = s.substring(left, right);
                if (isPalindrome(sub) && sub.length() > res.length()) {
                    res = sub;
                }
            }
        }
        return res;
    }

    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}