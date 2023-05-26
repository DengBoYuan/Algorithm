package com.leetcode.Leetcode81to100;

/*
    思路：动态规划，使用二维数组dp存储，dp[i][j]代表s1的前i个
    字符和s2的前j个字符是否可以匹配s3的前i+j个字符，初始dp[0][0]
    为true，最终返回dp[len1][len2]
 */

public class Leetcode97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
                }
            }
        }
        return dp[len1][len2];
    }
}
