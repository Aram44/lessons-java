package leetcode.les11;

import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(intToRoman(3749));
    }

    private static String intToRoman(int num) {
        int[] values =    {1000, 900, 500, 400, 100, 90,  50,  40, 10, 9,   5,  4,   1};
        String[] symbols ={"M",  "CM","D", "CD", "C","XC","L", "XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
                System.out.println(num);
            }
        }

        return sb.toString();
    }
}
