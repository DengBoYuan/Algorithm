package com.leetcode.Leetcode61to80;

/*
    思路：动态规划，dp[i][j]存储word1前i个字符到word2前j个字符
    的最小步数，第一行（即word1为空）的值为word2的长度，同理，第一列
    为word1的长度，其他的当1的第i个字符和2的第j个字符相同时，
    dp[i][j]= 1 + Math.min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]-1)
    不相同则dp[i][j]= 1 + Math.min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
 */

public class Leetcode72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = Math.min(1 + Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                } else {
                    dp[i][j] = Math.min(1 + Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1] + 1);
                }
            }
        }
        return dp[m+1][n+1];
    }
}
