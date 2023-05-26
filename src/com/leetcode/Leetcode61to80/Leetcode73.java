package com.leetcode.Leetcode61to80;

/*
    思路：使用两个数组分别标记该行或该列是否有0
    若有，则将其标为1，最后再将为1的行和列置为0
 */
public class Leetcode73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] line = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    line[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (line[i] == 1) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (col[i] == 1) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
