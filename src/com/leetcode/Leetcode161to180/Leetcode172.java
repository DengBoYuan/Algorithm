package com.leetcode.Leetcode161to180;

/*
    思路：当乘数中含有一个5因子，则会产生一个0，而
    如25 = 5 x 5,则含有2个5因子，所以0的个数就是
    乘数中5因子的个数，而5因子的个数等于当前数除以5
    若，结果大于0，则继续除以5，将每次的结果全部相加
    可得0的个数
 */
public class Leetcode172 {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n = n / 5;
        }
        return res;
    }
}
