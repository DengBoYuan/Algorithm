package com.leetcode.Leetcode121to140;

/*
    思路：双指针，分别从首尾向中间遍历，大写就转小写
    小写和数字不变，其他的跳过，有一个不匹配就返回false
 */
public class Leetcode125 {
    public boolean isPalindrome(String s) {
        int len = s.length();
        int left = 0, right = len-1;
        while (right > left) {
            char l = 0, r = 0;
            if (s.charAt(left) >= 'A' && s.charAt(left) <= 'Z') {
                l = (char)(s.charAt(left) + 32);
            } else if ((s.charAt(left) >= '0' && s.charAt(left) <= '9') || (s.charAt(left) >= 'a' && s.charAt(left) <= 'z')){
                l = s.charAt(left);
            } else {
                left++;
                continue;
            }
            if (s.charAt(right) >= 'A' && s.charAt(right) <= 'Z') {
                r = (char)(s.charAt(right) + 32);
            } else if ((s.charAt(right) >= '0' && s.charAt(right) <= '9') || (s.charAt(right) >= 'a' && s.charAt(right) <= 'z')){
                l = s.charAt(right);
            } else {
                right--;
                continue;
            }
            if (l != r) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
