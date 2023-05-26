package com.leetcode.Leetcode41to60;

import java.util.ArrayList;
import java.util.List;

/*
    思路：递归加代码回溯
 */
public class Leetcode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tem = new ArrayList<>();
        int len = nums.length;
        if (len == 1) {
            tem.add(nums[0]);
            res.add(tem);
            return res;
        }
        boolean[] flag = new boolean[len];
        element(nums, tem, res, flag);
        return res;
    }
    public void element(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] flag) {
        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                List<Integer> tem = new ArrayList<>(list);
                tem.add(nums[i]);
                flag[i] = true;
                element(nums, tem, res, flag);
                if (tem.size() == nums.length) {
                    res.add(tem);
                }
                flag[i] = false;
            }
        }
    }
}
