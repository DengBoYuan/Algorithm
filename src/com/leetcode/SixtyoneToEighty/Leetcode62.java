package com.leetcode.SixtyoneToEighty;

/*
    思路：动态规划：设置一个二维数组存储从起点到i行j列
        走法的数量，最后返回[m-1][n-1]，将[0][0]设置
        为1，第一行的每个等于前一列，第一列的每个等于前一行
        其他的都等于同行前一列加同列前一行，求[m-1][n-1]
 */
public class Leetcode62 {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    res[i][j] = 1;
                } else if (i == 0) {
                    res[i][j] = res[i][j-1];
                } else if (j == 0){
                    res[i][j] = res[i-1][j];
                } else {
                    res[i][j] = res[i-1][j] + res[i][j-1];
                }
            }
        }
        return res[m-1][n-1];
    }
}
