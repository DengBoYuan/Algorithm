package com.leetcode.SixtyoneToEighty;

import java.util.ArrayList;
import java.util.List;

/*
    思路：同77，递归实现
 */
public class Leetcode78 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tem = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        res.add(new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            dfs(nums, i, 0);
        }
        return res;
    }
    public void dfs(int[] nums, int len, int j) {
        if (tem.size() == len) {
            res.add(new ArrayList<>(tem));
            return;
        }
        int n = nums.length;
        if (tem.size()+n-j+1 < len) {
            return;
        }
        if (j < n) {
            tem.add(nums[j]);
            dfs(nums, len, j+1);
            tem.remove(tem.size()-1);
            dfs(nums, len, j+1);
        }
    }
}
