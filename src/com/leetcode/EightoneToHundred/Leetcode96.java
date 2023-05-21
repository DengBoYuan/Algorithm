package com.leetcode.EightoneToHundred;


//动态规划
public class Leetcode96 {
    public int numTrees(int n) {
        int[] dp = new int[20];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int tem = 0;
            for (int j = 0; j < i; j++) {
                tem += dp[j] * dp[i-1-j];
            }
            dp[i] = tem;
        }
        return dp[n];
    }
}
