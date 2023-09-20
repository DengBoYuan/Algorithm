package com.leetcode.Leetcode161to180;

import java.util.HashMap;

public class Leetcode166 {
    public String fractionToDecimal(int numerator, int denominator) {
        long numerator1 = (long) numerator;
        long denominator1 = (long) denominator;
        if (numerator1 % denominator1 == 0) {
            return (numerator1/denominator1) + "";
        }
        StringBuffer sb = new StringBuffer();
        if ((numerator1 > 0 && denominator1 < 0) || (numerator1 < 0 && denominator1 > 0)) {
            sb.append('-');
        }
        numerator1 = Math.abs(numerator1);
        denominator1 = Math.abs(denominator1);
        long num = numerator1 / denominator1;
        long remain = numerator1 - num * denominator1;
        sb.append(num);
        sb.append('.');
        int index = sb.indexOf(".");
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(remain, index);
        numerator1 = remain * 10;
        while (numerator1 != 0) {
            index++;
            num = numerator1 / denominator1;
            remain = numerator1 - denominator1 * num;
            sb.append(num);
            if (map.containsKey(remain)) {
                sb.insert(map.get(remain) + 1, "(");
                sb.append(')');
                break;
            } else {
                map.put(remain, index);
                numerator1 = remain * 10;
            }
        }
        return sb.toString();
    }
}
