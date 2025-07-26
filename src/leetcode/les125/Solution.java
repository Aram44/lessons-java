package leetcode.les125;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");;
        var len = (int) s.length() / 2;
        for(int i = 0; i < len; i++){
            var left = s.charAt(i);
            var rigth = s.charAt(s.length() - i - 1);
            if(left != rigth){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeV2(String s) {
        String simplified = s.replaceAll("[^A-Za-z0-9]", "");
        String reversed = new StringBuilder(simplified).reverse().toString();
        return simplified.equalsIgnoreCase(reversed);
    }
}
