package com.leetcode.Leetcode61to80;

public class Leetcode67 {
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int alen = a.length(), blen = b.length();
        int i = alen-1, j = blen-1;
        int flag = 0;
        while (i >= 0 && j >= 0) {
            int num = a.charAt(i)-'0' + b.charAt(j)-'0' + flag;
            sb.append(num % 2);
            flag = num / 2;
            i--;
            j--;
        }
        while (i >= 0) {
            int tem = a.charAt(i)-'0' + flag;
            sb.append(tem % 2);
            flag = tem / 2;
            i--;
        }
        while (j >= 0) {
            int tem = b.charAt(j)-'0' + flag;
            sb.append(tem % 2);
            flag = tem / 2;
            j--;
        }
        return sb.reverse().toString();
    }
}
