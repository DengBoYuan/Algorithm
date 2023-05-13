package com.leetcode.EightoneToHundred;

import java.util.ArrayList;
import java.util.List;

public class Leetcode89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            res.add(1);
            return res;
        }
        List<Integer> list = grayCode(n-1);
        res.addAll(list);
        for (int i = list.size(); i >= 0; i--) {
            res.add(list.get(i) + (int)Math.pow(2, n-1));
        }
        return res;
    }
}
