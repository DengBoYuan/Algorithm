package com.leetcode.Leetcode41to60;

import java.util.ArrayList;
import java.util.List;

public class Leetcode52 {
    public int totalNQueens(int n) {
        StringBuffer sb = new StringBuffer();
        List<List<String>> res = new ArrayList<>();
        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i++) {
            sb.append('.');
        }
        dfs(n, 0, ans, res, sb);
        return res.size();
    }
    public void dfs(int n, int i, int[][] ans, List<List<String>> res, StringBuffer source) {
        if (i == n) {
            List<String> tem = new ArrayList<>();
            for (int m = 0; m < n; m++) {
                source.setCharAt(ans[m][1], 'Q');
                tem.add(source.toString());
                source.setCharAt(ans[m][1], '.');
            }
            res.add(tem);
        }
        for (int j = 0; j < n; j++) {
            boolean flag = true;
            for (int k = 0; k < i; k++) {
                if (ans[k][1] == j || Math.abs(ans[k][0] - i) == Math.abs(ans[k][1] - j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans[i][0] = i;
                ans[i][1] = j;
                dfs(n, i+1, ans, res, source);
            }
        }
    }
}
