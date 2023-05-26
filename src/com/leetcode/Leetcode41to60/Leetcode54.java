package com.leetcode.Leetcode41to60;

import java.util.ArrayList;
import java.util.List;

/*
    思路：模拟过程
 */
public class Leetcode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[][] flag = new boolean[m][n];
        List<Integer> res = new ArrayList<>();
        int lflag = 1, rflag = 1;
        int i = 0, j = 0;
        while (true) {
            while (j >= 0 && j < n && !flag[i][j]) {
                res.add(matrix[i][j]);
                flag[i][j] = true;
                j += lflag;
            }
            j -= lflag;
            i += rflag;
            lflag = -lflag;
            if (i < 0 || i >= m || flag[i][j]) {
                break;
            }
            while (i >= 0 && i < m && !flag[i][j]) {
                res.add(matrix[i][j]);
                flag[i][j] = true;
                i += rflag;
            }
            i -= rflag;
            j += lflag;
            rflag = -rflag;
            if (j < 0 || j >= n || flag[i][j]) {
                break;
            }
        }
        return res;
    }
}
