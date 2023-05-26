package com.leetcode.Leetcode81to100;

/*
    思路：先遍历数组，将数组每个位置向左数连续1的个数存起来，
    然后再遍历数组，以1位右下角，依层向上求当前矩形面积，面积
    等于width（各层中连续1的最小数）乘以height（层数），将
    最大的返回，向上遍历时若出现连续1为0，则直接break（出现0
    则width为0，面积为0）
 */
public class Leetcode85 {
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] flag = new int[m][n];
        for (int i = 0; i < m; i++) {
            int num = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    flag[i][j] = 0;
                    num = 0;
                } else {
                    num++;
                    flag[i][j] = num;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int p = i;
                    int width = flag[i][j];
                    while (p >= 0) {
                        if (flag[p][j] == 0) {
                            break;
                        }
                        width = Math.min(width, flag[p][j]);
                        res = Math.max(res, width * (i-p+1));
                        p--;
                    }
                }
            }
        }
        return res;
    }
}
