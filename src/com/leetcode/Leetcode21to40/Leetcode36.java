package com.leetcode.Leetcode21to40;

import java.util.HashMap;

public class Leetcode36 {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character, Integer> square1 = new HashMap<>();
        HashMap<Character, Integer> square2 = new HashMap<>();
        HashMap<Character, Integer> square3 = new HashMap<>();
        HashMap<Character, Integer> line = new HashMap<>();
        HashMap<Character, Integer> row = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            line.clear();
            row.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] >= '0' && board[i][j] <= '9') {
                    line.put(board[i][j], line.getOrDefault(board[i][j], 0) + 1);
                    switch (j / 3) {
                        case 0:
                            square1.put(board[i][j], square1.getOrDefault(board[i][j], 0) + 1);
                            if (square1.get(board[i][j]) == 2) {
                                return false;
                            }
                            break;
                        case 1:
                            square2.put(board[i][j], square2.getOrDefault(board[i][j], 0) + 1);
                            if (square2.get(board[i][j]) == 2) {
                                return false;
                            }
                            break;
                        case 2:
                            square3.put(board[i][j], square3.getOrDefault(board[i][j], 0) + 1);
                            if (square3.get(board[i][j]) == 2) {
                                return false;
                            }
                            break;
                    }
                    if (line.get(board[i][j]) == 2) {
                        return false;
                    }
                }
                if (board[j][i] >= '0' && board[j][i] <= '9') {
                    row.put(board[j][i], row.getOrDefault(board[j][i], 0) + 1);
                    if (row.get(board[j][i]) == 2) {
                        return false;
                    }
                }
            }
            if (i % 3 == 2) {
                square1.clear();
                square2.clear();
                square3.clear();
            }
        }
        return true;
    }
}
