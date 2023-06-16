package com.leetcode.Leetcode101to120;

import java.util.List;

/*
    动态规划：使用dp[i][j]存储从顶部到位置（i，j）的最小路径和
    除首尾分别等于上一行首尾加本身，其他都等于上一行更小的那个加
    本身，最后返回最后一行最小的。
 */
public class Leetcode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len][len];
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == 0) {
                    dp[0][0] = triangle.get(0).get(0);
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                res = dp[len-1][i];
            } else {
                res = Math.min(res, dp[len-1][i]);
            }
        }
        return res;
    }
}
