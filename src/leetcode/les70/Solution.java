package leetcode.les70;

public class Solution {
    public static int[] cache;

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }

    public static int climbStairs(int n) {
        cache = new int[n+1];
        for(int i=0; i < n; i++){
            cache[i] = -1;
        }
        return dfs(n, 0);
    }

    public static int dfs(int n, int i){
        if(i >= n) return i == n ? 1 : 0;
        if(cache[i] != -1) return cache[i];
        return cache[i] = dfs(n, i + 1) + dfs(n, i + 2);
    }
}
