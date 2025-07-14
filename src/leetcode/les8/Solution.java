package leetcode.les8;

public class Solution {

    public static void main(String[] args) {
        System.out.println(myAtoi("-555"));
        System.out.println(myAtoi(" -042"));
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("42"));
    }

    public static int myAtoi(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        boolean negative = false;
        if (s.charAt(0) == '-') {
            negative = true;
            s = s.substring(1);
        } else if (s.charAt(0) == '+') {
            s = s.substring(1);
        }
        var res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                res.append(c);
            }else {
                break;
            }
        }
        var number = res.toString();
        if (number.isEmpty()){
            return 0;
        }
        var intNum = 0;
        try {
            intNum = Integer.parseInt(number);
            if (negative){
                intNum = -intNum;
            }
        } catch (NumberFormatException e) {
            if (negative){
                intNum = Integer.MIN_VALUE;
            }else{
                intNum = Integer.MAX_VALUE;
            }
        }
        return intNum;
    }
}
