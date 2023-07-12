package com.leetcode.Leetcode121to140;

import java.util.LinkedList;
import java.util.Queue;

/*
    思路：没被包围的o，一定是在边缘或者与在边缘的o相连
    所以先找出边缘的o，记录索引，然后使用广度优先搜索，
    将与边缘o和与边缘o相连的o置为a，最后将a全部变为o，
    其他的都是x
 */
public class Leetcode130 {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = 'A';
                queue.offer(new int[]{0, i});
            }
            if (board[m-1][i] == 'O') {
                board[m-1][i] = 'A';
                queue.offer(new int[]{m-1, i});
            }
        }
        for (int i = 0; i < m; i ++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'A';
                queue.offer(new int[]{i, 0});
            }
            if (board[i][n-1] == 'O') {
                board[i][n-1] = 'A';
                queue.offer(new int[]{i, n-1});
            }
        }
        while (!queue.isEmpty()) {
            int[] tem = queue.poll();
            if (tem[0] > 0 && board[tem[0]-1][tem[1]] == 'O') {
                board[tem[0]-1][tem[1]] = 'A';
                queue.offer(new int[]{tem[0]-1, tem[1]});
            }
            if (tem[0] < m-1 && board[tem[0]+1][tem[1]] == 'O') {
                board[tem[0]+1][tem[1]] = 'A';
                queue.offer(new int[]{tem[0]+1, tem[1]});
            }
            if (tem[1] > 0 && board[tem[0]][tem[1]-1] == 'O') {
                board[tem[0]][tem[1]-1] = 'A';
                queue.offer(new int[]{tem[0], tem[1]-1});
            }
            if (tem[1] < n-1 && board[tem[0]][tem[1]+1] == 'O') {
                board[tem[0]][tem[1]+1] = 'A';
                queue.offer(new int[]{tem[0], tem[1]+1});
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
