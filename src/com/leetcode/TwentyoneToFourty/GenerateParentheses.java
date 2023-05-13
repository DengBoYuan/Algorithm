package com.leetcode.TwentyoneToFourty;

import java.util.ArrayList;
import java.util.List;

/*
    第一个一定为（，故有个）与之匹配，剩余n-1对括号可如下分配
    "(" + 【i=p时所有括号的排列组合】 + ")" + 【i=q时所有括号的排列组合】
    p + q = n-1
 */


public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> list0 = new ArrayList<>();
        list0.add("");
        res.add(list0);
        List<String> list1 = new ArrayList<>();
        list1.add("()");
        res.add(list1);
        for (int i = 2; i <= n; i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = res.get(j);
                List<String> str2 = res.get(i - j - 1);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        String e = "(" + s1 + ")" + s2;
                        temp.add(e);
                    }
                }
            }
            res.add(temp);
        }
        return res.get(n);
    }
}
