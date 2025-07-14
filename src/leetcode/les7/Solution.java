package leetcode.les7;

public class Solution {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        if (x == 0){
            return 0;
        }
        String s = String.valueOf(x);
        boolean negative = s.charAt(0) == '-';
        try{
            if (negative) {
                s = s.substring(1);
                var res = new StringBuilder(s).reverse();
                var result = cleanStartZero(res.toString());
                return Integer.valueOf('-' + result);
            }else {
                var res = new StringBuilder(s).reverse();
                var result = cleanStartZero(res.toString());
                return Integer.valueOf(result);
            }
        }catch (Exception e){
            return 0;
        }

    }

    public static String cleanStartZero(String s) {
        while (s.charAt(0) == '0') {
            s = s.substring(1);
        }
        return s;
    }

}
