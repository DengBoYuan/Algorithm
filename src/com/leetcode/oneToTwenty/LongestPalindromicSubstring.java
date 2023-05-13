package com.leetcode.core.oneToTwenty;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int left;
        int right;
        String res = s.substring(0,1);
        int resLen = 1;
        int len;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                left = i - 1;
                right = i + 2;
                len = 2;
                while (left >= 0 && right < s.length()) {
                    if (s.charAt(left) == s.charAt(right)) {
                        len += 2;
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }
                if (len > resLen){
                    res = s.substring(left + 1,right);
                    resLen = len;
                }
            }
            left = i - 1;
            right = i + 1;
            len = 1;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    len += 2;
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            if (len > resLen){
                res = s.substring(left + 1,right);
                resLen = len;
            }
        }
        return res;
    }
}
