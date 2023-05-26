package com.leetcode.Leetcode21to40;

/*
    思路：递归
 */
public class Leetcode38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n-1);
        int len = s.length();
        StringBuffer sb = new StringBuffer();
        int counter = 0;
        char a = '0';
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                counter = 1;
                a = s.charAt(i);
                continue;
            }
            if (s.charAt(i) != a) {
                sb.append(counter);
                sb.append(a);
                a = s.charAt(i);
                counter = 1;
            } else {
                counter++;
            }
        }
        sb.append(counter);
        sb.append(a);
        return sb.toString();
    }
}
