package com.leetcode.Leetcode141to160;

public class Leetcode151 {
    public String reverseWords(String s) {
        s = s.trim();
        int n = s.length();
        StringBuffer sb = new StringBuffer();
        int right = n;
        boolean flag = false;
        for (int i = n-1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (flag) {
                    sb.append(s.substring(i+1, right));
                    sb.append(' ');
                    flag = false;
                }
            } else {
                if (!flag) {
                    right = i + 1;
                    flag = true;
                }
            }
        }
        sb.append(s.substring(0, right));
        String res = sb.toString().trim();
        return res;
    }
}
