package com.leetcode.Leetcode41to60;

import java.util.ArrayList;
import java.util.List;

/*
    思路：创建集合存储各位相乘后位数相同的积，例如：
         第x位是第i位和第x-i位的乘积的，全部存完后
         将集合中大于10的数取模留个位数，十位数向后
         移，直到每一位都是个位数后返回字符串

 */

public class Leetcode43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length(), len2 = num2.length();
        int maxlen = len1 + len2 - 2;
        List<Integer> nores = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= maxlen; i++) {
            int ele = 0;
            for (int j = 0; j <= Math.min(i, len1 - 1); j++) {
                if ((i - j) > (len2 - 1)) {
                    continue;
                }
                int tem1 = num1.charAt(len1-1-j) - '0';
                int tem2 = num2.charAt(len2-1-(i-j)) - '0';
                ele += tem1 * tem2;
            }
            nores.add(ele);
        }
        for (int i = 0; i < nores.size(); i++) {
            int x = nores.get(i);
            if (i == nores.size() - 1 && x >= 10) {
                sb.append(x%10);
                nores.add(x/10);
                continue;
            }
            if (i == nores.size() - 1 && x < 10) {
                sb.append(x);
                break;
            }
            sb.append(x%10);
            nores.set(i+1, nores.get(i+1) + x/10);
        }
        sb.reverse();
        return sb.toString();
    }
}
