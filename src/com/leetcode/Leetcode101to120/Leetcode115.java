package com.leetcode.Leetcode101to120;

/*
    思路：动态规划，题意即从s中选出字符与t匹配的种类数，
    dp[i][j]表示s从索引i之后的字符串和t从索引j之后的字
    符串匹配的个数，当s（i)与t（j）相等则可选择当前位置
    是否匹配，dp[i][j]=dp[i+1][j+1]（匹配）+dp[i+1][j]（不匹配），
    若不相等，则只有不匹配，即dp[i][j]=dp[i+1][j]
 */
public class Leetcode115 {
    public int numDistinct(String s, String t) {
        int slen = s.length(), tlen = t.length();
        if (t.length() > s.length()) {
            return 0;
        }
        int[][] dp = new int[slen+1][tlen+1];
        for (int i = 0; i <= slen; i++) {
            dp[i][tlen] = 1;
        }
        for (int i = 0; i < tlen; i++) {
            dp[slen][i] = 0;
        }
        for (int i = slen-1; i >= 0; i--) {
            for (int j = tlen-1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                } else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }
}
