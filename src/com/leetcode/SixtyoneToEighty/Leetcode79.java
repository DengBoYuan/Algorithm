package com.leetcode.SixtyoneToEighty;

/*
    思路：回溯，用一个矩阵标记当前位置是否使用过，每一次都
    向四周，有一个符合则为true，没有则复原标记，继续遍历
    开始先遍历找到头
 */

public class Leetcode79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, flag, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, boolean[][] flag, int i, int m, int n) {
        if (i == word.length()) {
            return true;
        }
        if (m < 0 || n < 0 || m >= board.length || n >= board[0].length) {
            return false;
        }
        char c = board[m][n];
        if (c != word.charAt(i) || flag[m][n]) {
            return false;
        }
        flag[m][n] = true;
        boolean res = dfs(board, word, flag, i+1, m-1, n) ||
                dfs(board, word, flag, i+1, m+1, n) ||
                dfs(board, word, flag, i+1, m, n-1) ||
                dfs(board, word, flag, i+1, m, n+1);
        if (!res) {
            flag[m][n] = false;
        }
        return res;
    }
}