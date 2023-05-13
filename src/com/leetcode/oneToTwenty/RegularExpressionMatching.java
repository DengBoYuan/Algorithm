package com.leetcode.core.oneToTwenty;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int sIndex = 0;
        int pIndex = 0;
        char pre = ' ';
        while (sIndex < s.length() && pIndex < p.length()) {
            if (p.charAt(pIndex) == '.') {
                sIndex++;
                pIndex++;
                pre = '.';
            } else if (p.charAt(pIndex) == '*') {

            } else if (p.charAt(pIndex) == s.charAt(sIndex)) {
                pre = p.charAt(pIndex);
                pIndex++;
                sIndex++;
            } else {
                pre = p.charAt(pIndex);
                pIndex++;
            }
        }

        if (sIndex == s.length() && pIndex == p.length()) {
            return true;
        }
        return false;
    }
}
