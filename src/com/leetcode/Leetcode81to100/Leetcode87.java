package com.leetcode.Leetcode81to100;

/*
    思路：动态规划，使用一个三维数组存储记录，dp[i][j][len]表示
    第一个子串的第i个字符开始，第二个子串的第j个字符开始，长度为
    len的子串是否是扰乱字符串，遍历字符串的空格将他们分隔开，然后
    判断不交换或交换是否匹配，满足一种情况即可，
 */

public class Leetcode87 {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        //子串长度
        for (int len = 2; len <= n; len++) {
            //s1子串起始位置
            for (int i = 0; i <= n-len; i++) {
                //s2子串起始位置
                for (int j = 0; j <= n-len; j++) {
                    for (int k = 1; k < len; k++) {
                        if (dp[i][j][k] && dp[i + k][j + k][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                        // 第二种情况：S1 -> T2, S2 -> T1
                        // S1 起点 i，T2 起点 j + 前面那段长度 len-k ，S2 起点 i + 前面长度k
                        if (dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}
