package algorithms.leetcode.les121;

public class Solution {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 5, 4, 3, 1}));
        System.out.println(maxProfit(new int[]{2, 1, 2, 0, 1}));
        System.out.println(maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit2(new int[]{7, 6, 5, 4, 3, 1}));
        System.out.println(maxProfit2(new int[]{2, 1, 2, 0, 1}));
    }

    public static int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }
        return profit;
    }

    public static int maxProfit2(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        for (int sell : prices){
            profit = Math.max(profit, sell - buy);
            buy = Math.min(buy, sell);
        }
        return profit;
    }
}
