package leetcode.les994;

public class Solution {

    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
        System.out.println(orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}}));
        System.out.println(orangesRotting(new int[][]{{1,2}}));
    }

    public static int orangesRotting(int[][] grid) {
        if(grid == null){
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(grid[i][j] == 2) {
                    grid[i][j] = 1;
                    traversal(grid, i, j, r, c, 2);
                }
            }
        }
        int max=2;
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(grid[i][j] == 1) {
                    return -1;
                }
                max=Math.max(max, grid[i][j]);
            }
        }
        return max - 2;
    }

    public static void traversal(int[][] grid, int i, int j, int r, int c, int time){
        if(i < 0 || i >= r || j < 0 || j >= c || grid[i][j]==0 || (grid[i][j]>=2 && grid[i][j]<time)) return;
        grid[i][j] = time;
        time++;
        traversal(grid, i+1, j, r, c, time);
        traversal(grid, i-1, j, r, c, time);
        traversal(grid, i, j+1, r, c, time);
        traversal(grid, i, j-1, r, c, time);
    }
}
