package leetcode.les238;

public class Solution {
    public static void main(String[] args) {
        System.out.println(productExceptSelf(new int[]{1, 2, 3, 4}));
    }

    public static int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            var prevVal = 1;
            if(i != 0){
                prevVal = prefix[i-1];
            }
            prefix[i] = prevVal * nums[i];
            prevVal = 1;
            if(i != 0){
                prevVal = postfix[nums.length - i];
            }
            postfix[nums.length - i - 1] = prevVal * nums[nums.length - i - 1];
        }
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                res[i] = postfix[i+1];
            }else if (i == nums.length -1){
                res[i] = prefix[i-1];
            }else{
                res[i] = prefix[i-1] * postfix[i+1];
            }
        }
        return res;
    }
}
