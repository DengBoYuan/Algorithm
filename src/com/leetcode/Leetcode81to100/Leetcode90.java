package com.leetcode.Leetcode81to100;

import java.util.*;
/*
    思路：同78，首先数组排序，数组中每个数的状态只有两个
    在子集或不在子集，然后使用回溯。去重：当确定一个数不在
    子集后，它后面的所有与它相同的数都不在子集，此时就可去重
 */
public class Leetcode90 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        dfs(0, nums);
        return res;
    }
    public void dfs(int i, int[] nums) {
        if (i == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        dfs(i+1, nums);
        int x  = nums[i];
        list.remove(list.size()-1);
        while (i < nums.length && nums[i] == x) {
            i++;
        }
        dfs(i, nums);
    }
}
