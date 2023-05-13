package com.leetcode.FourtyoneToSixty;

/*
    思路：动态规划dp：创建一个二维数组存储s前i个和p前j个字符是否匹配
         初始化：dp[0][0]为true，若p前i个字符为*，则可匹配0个
         所以dp[0][i]为true，其他的遍历确定，直到遍历到最后一个
         返回dp[s.length][p.length]
 */

public class Leetcode44 {
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        boolean[][] dp = new boolean[slen+1][plen+1];
        dp[0][0] = true;
        for (int i = 1; i <= plen; i++) {
            if (p.charAt(i-1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= plen; j++) {
                if (p.charAt(j-1) == '*') {
                    dp[i][j] = (dp[i-1][j] || dp[i][j-1]);
                } else if (p.charAt(j-1) == '?' || s.charAt(i-1) == p.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[slen][plen];
    }
}
