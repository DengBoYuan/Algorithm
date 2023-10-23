package com.leetcode.Leetcode181to200;

public class Leetcode190 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (n != 0) {
                res |= (n & 1) << (31-i);
            } else {
                break;
            }
            n >>>= 1;
        }
        return res;
    }
}
