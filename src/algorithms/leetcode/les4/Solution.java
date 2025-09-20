package algorithms.leetcode.les4;

public class Solution {

    public static void main(String[] args) {
        var res = findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.println("res is " + res);
    }
    private static int[] getMiddleVals(int idx, int[] nums) {
        int maxLeft = idx >= 0 ? nums[idx] : Integer.MIN_VALUE;
        int nextIdx = idx + 1;
        int minRight = nextIdx < nums.length ? nums[nextIdx] : Integer.MAX_VALUE;
        return new int[]{maxLeft, minRight};
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int s1 = nums1.length, s2 = nums2.length;
        int total = s1 + s2;
        int half = total / 2;
        boolean isOdd = (total % 2) == 1;

        int left = 0, right = s1;

        while (left <= right) {
            int idx1 = (left + right) / 2;
            int idx2 = half - idx1;

            int maxLeft1 = (idx1 == 0) ? Integer.MIN_VALUE : nums1[idx1 - 1];
            int minRight1 = (idx1 == s1) ? Integer.MAX_VALUE : nums1[idx1];

            int maxLeft2 = (idx2 == 0) ? Integer.MIN_VALUE : nums2[idx2 - 1];
            int minRight2 = (idx2 == s2) ? Integer.MAX_VALUE : nums2[idx2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if (isOdd) {
                    return Math.min(minRight1, minRight2);
                } else {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
            } else if (maxLeft1 > minRight2) {
                right = idx1 - 1;
            } else {
                left = idx1 + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted properly.");
    }
}
