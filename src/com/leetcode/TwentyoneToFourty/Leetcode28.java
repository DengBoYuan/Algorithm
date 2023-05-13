package com.leetcode.TwentyoneToFourty;

public class Leetcode28 {
    public int strStr(String haystack, String needle) {
        int res = -1;
        int hLen = haystack.length();
        int nLen = needle.length();
        if (hLen < nLen) {
            return -1;
        }
        int i = 0, j = 0;
        while (i < hLen && j < nLen) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                res = i;
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
                res = -1;
            }
        }
        if (j == nLen) {
            return res - nLen + 1;
        } else {
            return -1;
        }
    }
}
