package com.leetcode.core.oneToTwenty;

public class RomanToInteger {
    public int romanToInt(String s) {
        int i = 0;
        int res = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'M') {
                res += 1000;
                i++;
            }
            if (s.charAt(i) == 'D') {
                res += 500;
                i++;
            }
            if (s.charAt(i) == 'C') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'M') {
                    res += 900;
                    i += 2;
                } else if (i + 1 < s.length() && s.charAt(i +1) == 'D') {
                    res += 400;
                    i += 2;
                } else {
                    res += 100;
                    i++;
                }
            }
            if (s.charAt(i) == 'L') {
                res += 50;
                i++;
            }
            if (s.charAt(i) == 'X') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'C') {
                    res += 90;
                    i += 2;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'L') {
                    res += 40;
                    i += 2;
                } else {
                    res += 10;
                    i++;
                }
            }
            if (s.charAt(i) == 'V') {
                res += 5;
                i++;
            }
            if (s.charAt(i) == 'I') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'X') {
                    res += 9;
                    i += 2;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'V') {
                    res += 4;
                    i += 2;
                } else {
                    res += 1;
                    i++;
                }
            }
        }
        return res;
    }
}
