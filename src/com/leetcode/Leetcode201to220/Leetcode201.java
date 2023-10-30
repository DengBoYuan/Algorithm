package com.leetcode.Leetcode201to220;

public class Leetcode201 {
    public int rangeBitwiseAnd(int left, int right) {
        if (left == right) {
            return left;
        }
        int res = 0;
        int dis = right - left;
        int rate = 1;
        int count = 0;
        while (right >= rate) {
            if (rate > left || count == 30) {
                return res;
            }
            int bit = (left / rate) % 2;
            if (bit == 1) {
                int tem = left % rate;
                if ((rate - tem) > dis) {
                    res += rate;
                }
            }
            rate *= 2;
            count++;
        }
        return res;
    }
}
