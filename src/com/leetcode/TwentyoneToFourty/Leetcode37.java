package com.leetcode.TwentyoneToFourty;

import java.util.ArrayList;
import java.util.List;

public class Leetcode37 {
    boolean[][] line = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][][] block = new boolean[3][3][9];
    List<int[]> spaces = new ArrayList<>();
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[] {i, j});
                } else {
                    int num = board[i][j] - '0' - 1;
                    line[i][num] = true;
                    col[j][num] = true;
                    block[i/3][j/3][num] = true;
                }
            }
        }
        dfs(board, 0);
    }
    public void dfs(char[][] board, int n) {
        if (n == spaces.size()) {
            return;
        }
        int[] pos = spaces.get(n);
        int i = pos[0], j = pos[1];
        for (int digit = 0; digit < 9; digit++) {
            if (!line[i][digit] || !col[j][digit] || !block[i/3][j/3][digit]) {
                board[i][j] = (char)(digit + 1);
                line[i][digit] = true;
                col[j][digit] = true;
                block[i/3][j/3][digit] = true;
                dfs(board, n+1);
                line[i][digit] = false;
                col[j][digit] = false;
                block[i/3][j/3][digit] = false;
            }
        }
    }
}
