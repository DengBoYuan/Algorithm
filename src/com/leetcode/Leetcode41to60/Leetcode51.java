package com.leetcode.Leetcode41to60;

import java.util.ArrayList;
import java.util.List;

/*
    思路：代码回溯：
            首先创建一个全是'.'的长度为n的字符串作为源串，然后行优先
            开始遍历，一行一个，遍历每一列，将当前位置与前几行已经填
            的数比较，若当前位置的列有重复或与当前位置的行的差和列的
            差的绝对值相等（即同一斜线），则直接过，否则将当前位置的
            行列填入数组ans中，当ans填完最后一行，就将数组的行列位
            置的'.'改为'Q'然后加入结果
 */
public class Leetcode51 {
    public List<List<String>> solveNQueens(int n) {
        StringBuffer sb = new StringBuffer();
        List<List<String>> res = new ArrayList<>();
        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i++) {
            sb.append('.');
        }
        dfs(n, 0, ans, res, sb);
        return res;
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
