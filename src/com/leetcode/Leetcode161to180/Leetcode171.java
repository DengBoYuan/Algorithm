package com.leetcode.Leetcode161to180;

public class Leetcode171 {
    public int titleToNumber(String columnTitle) {
        int len = columnTitle.length();
        int res = 0;
        int mul = 1;
        for (int i = len-1; i >= 0; i--) {
            int num = columnTitle.charAt(i) - 'A' + 1;
            res += num * mul;
            mul *= 26;
        }
        return res;
    }
}
