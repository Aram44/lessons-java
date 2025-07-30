package leetcode.les973;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(kClosest(new int[][]{{1,3},{-2,2}}, 2));
    }

    public static int[][] kClosest(int[][] points, int k) {
        if(points == null){
            return points;
        }
        Arrays.sort(points, (a, b) -> (a[0] * a[0] + a[1] * a[1]) -
                (b[0] * b[0] + b[1] * b[1]));
        return Arrays.copyOfRange(points, 0, k);
    }
}
