package com.leetcode.Leetcode41to60;

public class Leetcode58 {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        boolean flag = false;
        int res = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && !flag) {
                continue;
            }
            if (s.charAt(i) == ' ' && flag) {
                break;
            }
            if (s.charAt(i) != ' ') {
                flag = true;
                res++;
            }
        }
        return res;
    }
}
