package algorithms;

import java.util.Arrays;

public class FindBiggestNumber {
    public static void main(String[] args) {
        final int[] digits = {3, 1, 7, 9, 9, 5};
        System.out.println("Max num is: " + maxNumberFromDigits(digits));
    }

    public static String maxNumberFromDigits(int[] digits) {
        Arrays.sort(digits);
        StringBuilder res = new StringBuilder();
        for (int i = digits.length - 1; i>= 0 ; i--) {
            res.append(digits[i]);
        }
        return res.toString();
    }
}