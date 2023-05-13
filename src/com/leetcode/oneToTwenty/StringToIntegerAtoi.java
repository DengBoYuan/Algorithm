package com.leetcode.core.oneToTwenty;

public class StringToIntegerAtoi {
    public int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int i = 0;
        int sign = 1;
        long res = 0;
        int num;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = s.charAt(i) == '+' ? 1 : -1;
            i++;
        }
        while (i < s.length()) {
            num = s.charAt(i) - '0';
            if (num < 0 || num > 9) {
                break;
            }
            res = res * 10 + num;
            if (res * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (res * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            i++;
        }
        return (int)(sign * res);
    }
}
