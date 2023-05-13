package com.leetcode.SixtyoneToEighty;

public class Leetcode66 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int flag = 0;
        digits[len-1] += 1;
        for (int i = len - 1; i >= 0; i++) {
            digits[i] += flag;
            if (digits[i] == 10) {
                digits[i] = 0;
                flag = 1;
            } else {
                flag = 0;
                break;
            }
        }
        if (flag == 1) {
            int[] res = new int[len+1];
            res[0] = 1;
            return res;
        } else {
            return digits;
        }
    }
}
