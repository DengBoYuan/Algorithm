package com.leetcode.TwentyoneToFourty;

import java.util.ArrayList;
import java.util.List;

/*
    思路：递归：从数组第一个索引开始递归，每次有两个选择：
            1.往tem集合中加入当前元素，索引不变，继续递归
            2.不添加元素，索引加一，继续递归
         当索引等于数组长度或tem中元素和大于等于target值，结束递归
         并将元素和等于target的tem加入res中，最后返回res
 */
public class Leetcode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }
    public void dfs(int[] candidates, int ans, int target, List<Integer> tem, List<List<Integer>> res) {
        if (target == 0) {
            res.add(tem);
        }
        if (target > 0 && ans < candidates.length) {
            dfs(candidates, ans + 1, target, new ArrayList<>(tem), res);
            tem.add(candidates[ans]);
            target -= candidates[ans];
            dfs(candidates, ans, target, tem, res);
        }
    }
}
