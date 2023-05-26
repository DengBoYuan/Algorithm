package com.leetcode.Leetcode41to60;

import java.util.*;

/*
    思路同46，不同在于防止在同一个位置填入相同的数：
        先将数组排序，使相同数位置相邻，然后若当前位置已
        填过（标记为true）或已填过相同的数（当前与前一个数相同并且前一个位置没标记）
        则直接过，什么都不做
 */
public class Leetcode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        if (nums.length == 1) {
            List<Integer> a = new ArrayList<>();
            a.add(nums[0]);
            res.add(a);
            return res;
        }
        Arrays.sort(nums);
        dfs(res, nums, new ArrayList<>(), flag);
        return res;
    }
    public void dfs(List<List<Integer>> res, int[] nums, List<Integer> list, boolean[] flag) {
        for (int i = 0; i < nums.length; i++) {
            if (flag[i] || (i > 0 && nums[i] == nums[i-1] && !flag[i-1])) {
                continue;
            }
            List<Integer> tem = new ArrayList<>(list);
            tem.add(nums[i]);
            flag[i] = true;
            dfs(res, nums, tem, flag);
            if (tem.size() == nums.length) {
                res.add(tem);
            }
            flag[i] = false;
        }
    }
}
