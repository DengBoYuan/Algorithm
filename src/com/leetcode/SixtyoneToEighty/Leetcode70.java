package com.leetcode.SixtyoneToEighty;

public class Leetcode70 {
    /*
    方法一：数学法，排列组合问题，每次步一阶，总共n步
    其中0步是二阶，每加一步二阶的，步数减一，二阶的步数
    最多为一阶步数（初始步数）的一半，结果为所有情况和
    （即C（0，n）+C（1，n-1）+C（2，n-2）+···+C（n/2，n/2））
    public int climbStairs(int n) {
        int res = 0;
        for (int i = 0; i <= n/2; i++) {
            res += listNum(i, n-i);
        }
        return res;
    }
    public long listNum(int m, int n) {
        int i = n, j = Math.min(m, n-m);
        long res = 1;
        for (int k = 1; k <= j; k++) {
            res = res * (i-k+1) / k;
        }
        return res;
    }
    */

    /*
    方法二：动态规划，建一个长度为n的数组，每个位置
    存储从起始到当前位置的情况数量，最后返回数组最后一个
    */
    public int climbStairs(int n) {
        if (n  == 1) {
            return 1;
        }
        int[] flag = new int[n];
        flag[0] = 1;
        flag[1] = 2;
        for (int i = 2; i < n; i++) {
            flag[i] = flag[i-1] + flag[i-2];
        }
        return flag[n-1];
    }
}
