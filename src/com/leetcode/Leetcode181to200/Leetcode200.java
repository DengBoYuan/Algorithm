package com.leetcode.Leetcode181to200;

/*
    思路：深度优先搜索dfs，遍历数组，当遍历到1时，说明是岛屿
    此时使用dfs，每次遍历到1后修改为2，这样就可以避免重复；
    然后每次开始碰到岛屿让res++，最后返回res
 */
public class Leetcode200 {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(int i, int j, char[][] grid) {
        int m = grid.length, n = grid[0].length;
        grid[i][j] = '2';
        if (j > 0 && grid[i][j-1] == '1') {
            dfs(i, j-1, grid);
        }
        if (i > 0 && grid[i-1][j] == '1') {
            dfs(i-1, j, grid);
        }
        if (j < n-1 && grid[i][j+1] == '1') {
            dfs(i, j+1, grid);
        }
        if (i < m-1 && grid[i+1][j] == '1') {
            dfs(i+1, j, grid);
        }
    }
}
