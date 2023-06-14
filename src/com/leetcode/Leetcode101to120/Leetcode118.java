package com.leetcode.Leetcode101to120;

import java.util.ArrayList;
import java.util.List;

/*
    思路：第一行直接加个1，从第二行开始，首尾是1，中间是
    上一行的两个和
 */
public class Leetcode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            if (i == 1) {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                res.add(list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                for (int j = 1; j < i-1; j++) {
                    list.add(res.get(i-2).get(j-1) + res.get(i-2).get(j));
                }
                list.add(1);
                res.add(list);
            }
        }
        return res;
    }
}
