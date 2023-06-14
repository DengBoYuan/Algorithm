package com.leetcode.Leetcode101to120;

import java.util.ArrayList;
import java.util.List;

/*
    思路：同118
 */
public class Leetcode119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            if (i == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                res.add(list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                for (int j = 1; j < i; j++) {
                    list.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                }
                list.add(1);
                res.add(list);
            }
        }
        return res.get(rowIndex);
    }
}
