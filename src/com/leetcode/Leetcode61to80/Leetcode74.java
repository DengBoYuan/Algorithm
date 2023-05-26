package com.leetcode.Leetcode61to80;

/*
    思路：两次二分，第一次在第一列中找出第一个大于target的行，
        所在行在该行的上一行，第二次在所在行中找是否存在target
        存在则返回true，否则false
 */
public class Leetcode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        if (matrix[0][0] > target || matrix[m-1][n-1] < target) {
            return false;
        }
        int left = 0, right = m-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int row = Math.max(left, right) - 1;
        left = 0;
        right = n-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
