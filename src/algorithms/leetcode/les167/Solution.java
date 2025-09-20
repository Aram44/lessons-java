package algorithms.leetcode.les167;

public class Solution {
    public static void main(String[] args) {
        twoSum(new int[]{2, 7, 11, 15}, 9);
    }

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return numbers;
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                System.out.println(left + ":" + right);
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }
}
