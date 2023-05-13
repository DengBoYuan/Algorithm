package com.leetcode.FourtyoneToSixty;

/*
    思路：模拟过程
 */
public class Leetcode59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int lflag = 1, rflag = 1;
        boolean[][] flag = new boolean[n][n];
        int i = 0, j = 0, x = 1;
        while (true) {
            while (j >= 0 && j < n && !flag[i][j]) {
                res[i][j] = x;
                flag[i][j] = true;
                j += lflag;
                x++;
            }
            j -= lflag;
            i += rflag;
            lflag = -lflag;
            if (i < 0 || i >= n || flag[i][j]) {
                break;
            }
            while (i >= 0 && i < n && !flag[i][j]) {
                res[i][j] = x;
                flag[i][j] = true;
                i += rflag;
                x++;
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
