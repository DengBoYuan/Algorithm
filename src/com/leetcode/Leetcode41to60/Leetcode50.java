package com.leetcode.Leetcode41to60;

/*
    思路：快速幂：
            将x，n转换为二进制运算，例如101^1011=101^1 * 101^10 * 101^000 * 101^1000
            （1011=1+10+000+1000）而x^10 = x^1 * x^1（每多一位相当于x自己二次方），所以
            只要当n最后一位是1时，将res *= x，然后n右移，x自乘方，此时x相当于将n的位数计算了
 */
public class Leetcode50 {
    public double myPow(double x, int n) {
        int flag = 1;
        double res = 1;
        long m = n;
        if (m < 0) {
            flag = -1;
            m = Math.abs(m);
        }
        if (m == 0) {
            return 1;
        }
        while (m > 0) {
            if ((m & 1) == 1) {
                res *= x;
            }
            m = m >> 1;
            x *= x;
        }
        if (flag == -1) {
            res = 1/res;
        }
        return res;
    }
}
