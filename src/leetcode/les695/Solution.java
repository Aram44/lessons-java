package leetcode.les695;

public class Solution {
    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        }));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        var r = grid.length;
        var c = grid[0].length;
        int max = 0;
        for(int i=0; i < r; i++){
            for(int j=0; j < c; j++){
                if(grid[i][j] == 1) {
                    max = Math.max(traversal(grid, i, j, r, c, 0), max);
                }
            }
        }
        return max;
    }

    public static int traversal(int[][] grid, int i, int j, int r, int c, int max) {
        if(i < 0 || j < 0 || i >= r || j >= c || grid[i][j]==0) return max;
        grid[i][j] = 0;
        max++;
        max = traversal(grid, i + 1, j, r, c, max);
        max = traversal(grid, i - 1, j, r, c, max);
        max = traversal(grid, i, j + 1, r, c, max);
        max = traversal(grid, i, j - 1, r, c, max);
        return max;
    }
}
