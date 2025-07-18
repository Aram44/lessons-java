package leetcode.les200;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) {
        System.out.println(numIslands(new int[][] {{0,1,1,1,0}, {0,1,0,1,0}, {1,1,0,0,0}, {0,0,0,0,0}}));
        System.out.println(numIslands(new int[][] {{1,1,0,0,1}, {1,1,0,0,1}, {0,0,1,0,0}, {0,0,0,1,1}}));
    }

    public static int numIslands(int[][] grid){
        if(grid==null||grid.length==0||grid[0].length==0) return 0;
        int lendsCount = 0;
        Set<int[]> visited = new HashSet<>();
        int rcount = grid.length, ccount = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    visited.add(new int[]{i, j});
                    bfs(grid, i, j, rcount, ccount);
                    lendsCount++;
                }
            }
        }
        return lendsCount;
    }

    private static void bfs(int[][] grid, int i, int j, int rcount, int ccount) {
        if (i < 0 || i >= rcount || j < 0 || j >= ccount) return;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1];
            grid[x][y] = 0;
            for (var dir: dirs){
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= rcount || ny < 0 || ny >= ccount || grid[nx][ny] == 0) continue;
                queue.add(new int[]{nx, ny});
                grid[nx][ny] = 0;
            }
        }
    }
}
