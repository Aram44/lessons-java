package leetcode.les153;

public class Solution {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 6, 7, 8, 9, 1, 2}));
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(findMin(new int[]{1}));
        System.out.println(findMin(new int[]{3, 1, 2}));
        System.out.println(findMin(new int[]{2, 3, 1}));
        System.out.println(findMin(new int[]{5, 1, 2, 3, 4}));
    }

    public static int findMin(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }
        int i = 0, j = nums.length - 1;
        int mid = nums[0];
        int end = nums[nums.length - 1];
        while (i <= j) {
            mid = i + (j - i) / 2;
            var last = Math.min(mid + 1, nums.length - 1);
            var first = Math.max(mid - 1, 0);
            if (nums[mid] < nums[last] && nums[mid] < nums[first]) {
                return nums[mid];
            }
            if (nums[mid] > end) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return nums[mid];
    }

    public static int findMinV2(int[] nums) {
        int i=0;
        int j=nums.length-1, mid=-1,ans=Integer.MAX_VALUE;
        while(i<=j){
            mid=(i+j)/2;
            ans=Math.min(ans,nums[mid]);
            if(nums[mid]>=nums[j]){
                i=mid+1;
            } else{
                j=mid-1;
            }
        }
        return ans;
    }
}
