package com.leetcode.Leetcode161to180;


/*
    思路：动态规划，从右下到左上，此时不必关系路径和，dp（i，j）代表从（i，j）
    到右下的最小初始值，且每个初始值不能小于1，所以每次只需计算max（min（dp（i+1，j），dp（i，j+1）-dungeon(i,j）），1）
    最后返回dp（0,0）
 */
public class Leetcode174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i == m-1 && j == n-1) {
                    dp[i][j] = Math.max(1 - dungeon[i][j], 1);
                } else if (i == m-1) {
                    dp[i][j] = Math.max(dp[i][j+1] - dungeon[i][j], 1);
                } else if (j == n-1) {
                    dp[i][j] = Math.max(dp[i+1][j] - dungeon[i][j], 1);
                } else {
                    dp[i][j] = Math.max(Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j], 1);
                }
            }
        }
        return dp[0][0];
    }
}
