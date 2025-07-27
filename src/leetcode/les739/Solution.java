package leetcode.les739;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperaturesV2(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70})));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0)
            return new int[0];
        int rigth = 1;
        int[] res = new int[temperatures.length];
        for (int left = 0; left < temperatures.length - 1; left++) {
            rigth = left + 1;
            while (temperatures[left] >= temperatures[rigth] && rigth < temperatures.length - 1) {
                rigth++;
            }
            if (temperatures[left] < temperatures[rigth])
                res[left] = rigth - left;
        }
        return res;
    }

    public static int[] dailyTemperaturesV2(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n) {
                if (temperatures[j] > temperatures[i]) {
                    break;
                }
                j++;
            }
            res[i] = (j == n) ? 0 : j - i;
        }
        return res;
    }
}
