package algorithms.leetcode.les215;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
    }

    public static int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length < k){
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i : nums){
            pq.add(i);
        }
        for(int i = 0; i < k - 1; i++){
            pq.poll();
        }
        return pq.peek();
    }
}
