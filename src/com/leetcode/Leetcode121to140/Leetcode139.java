package com.leetcode.Leetcode121to140;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    思路：动态规划，dp[i]表示s前i个字符是否可拆分，状态
    转移方程为前j个可拆分并且剩下的是字典中的单词，即
    dp[i] = dp[j] && set.contains(s.substring(j, i-1))
    最后返回dp[len]
 */
public class Leetcode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i-1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
