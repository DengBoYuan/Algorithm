package com.leetcode.core.oneToTwenty;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String s = "" + x;
        for (int left = 0; left < s.length() / 2; left++) {
            if (s.charAt(left) != s.charAt(s.length() - left - 1)) {
                return false;
            }
        }
        return true;
    }
}
