package com.leetcode.core.oneToTwenty;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        int len = s.length();
        String res = "";
        int index;
        for (int i = 1; i <= numRows; i++) {
            index = i - 1;
            while (index < len) {
                if (index < len && (numRows - i) != 0) {
                    res = res + s.charAt(index);
                    index += (numRows - i) * 2;
                }
                if (index < len && (i - 1) != 0) {
                    res = res + s.charAt(index);
                    index += (i - 1) * 2;
                }
            }
        }
        return res;
    }
}
