package com.leetcode.Leetcode121to140;

import java.util.Arrays;

/*
    思路：动态规划，同131先将字符串预处理，使用dp[i][j]
    存储s[i,j]是否是回文串，然后用flag[i]存储s的前i个
    字符的最小分割数，当dp[0][i]为true，即前i个是回文，
    则不需要分割，flag[i]为0，否则为s[j]+1，其中dp[j+1][i]
    为true，即在末尾分割出一个回文串，最后递推到s，返回结果
 */
public class Leetcode132 {
    public int minCut(String s) {
        int len = s.length();
        int[] flag = new int[len];
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], true);
        }
        for (int i = len-2; i >= 0; i--) {
            for (int j = i+1; j < len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
            }
        }
        Arrays.fill(flag, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            if (dp[0][i]) {
                flag[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (dp[j+1][i]) {
                        flag[i] = Math.min(flag[i], flag[j] + 1);
                    }
                }
            }
        }
        return flag[len-1];
    }
}
