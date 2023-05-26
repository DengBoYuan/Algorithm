package com.leetcode.core.oneToTwenty;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        String temp = "";
        int subLen;
        for (int i = 0; i <= strs[0].length(); i++) {
            temp = strs[0].substring(0, i);
            for (int j = 0; j < strs.length; j++) {
                subLen = Math.min(i, strs[j].length());
                if (!temp.equals(strs[j].substring(0, subLen))) {
                    return res;
                }
            }
            res = temp;
        }
        return res;
    }
}
