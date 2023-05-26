package com.leetcode.Leetcode41to60;

/*
    思路：把矩阵看做若干个方框组成，旋转后数会在方框
        的一条边到另一条边，按方框遍历，将每条边同
        一位置的四个数放在一次修改，直到最后一个方框
 */
public class Leetcode48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int tem = 0;
        for (int i = 0; 2*i+1 < n; i++) {
            for (int j = i; j < n-1-i; j++) {
                tem = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tem;
            }
        }
    }
}
