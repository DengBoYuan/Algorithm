package com.leetcode.Leetcode161to180;

public class Leetcode168 {
    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber != 0) {
            int remainder = columnNumber % 26;
            if (remainder == 0) {
                remainder = 26;
            }
            sb.insert(0, (char) ('A' + remainder - 1));
            columnNumber = (columnNumber - remainder) / 26;
        }
        return sb.toString();
    }
}
