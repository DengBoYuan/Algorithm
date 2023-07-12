package com.leetcode.Leetcode121to140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    思路：首先维护一个二维数组dp，用以存储s（i，j）是否是回文串
    当i=j时，为true，其他情况为s.charAt(i) == s.charAt(j)
    && dp[i+1][j-1]，即首尾字符相同并且中间的是回文串，dp维护
    完了之后，使用递归将所有情况遍历一遍，当遍历到末尾符合要求的
    结果就加入res，最后返回res
 */
public class Leetcode131 {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], true);
        }
        for (int i = len-2; i >= 0; i--) {
            for (int j = i+1; j < len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
            }
        }
        re(s, new ArrayList<>(), 0, 0, dp);
        return res;
    }
    public void re(String s, List<String> list, int pre, int cur, boolean[][] dp) {
        if (cur == s.length()) {
            return;
        }
        if (dp[pre][cur]) {
            List<String> tem = new ArrayList<>(list);
            tem.add(s.substring(pre, cur+1));
            if (cur == s.length()-1) {
                res.add(tem);
                return;
            }
            re(s, tem, cur+1, cur+1, dp);
        }
        re(s, list, pre, cur+1, dp);
    }
}
