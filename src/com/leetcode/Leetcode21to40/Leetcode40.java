package com.leetcode.Leetcode21to40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode40 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        return res;
    }
    public void dfs(int target, List<Integer> tem, int index, int[] candidates, int pre) {
        if (target == 0) {
            res.add(new ArrayList<>(tem));
            return;
        }
        if (index == candidates.length || pre == candidates[index]) {
            return;
        }
        if (target < 0) {
            tem.remove(tem.size()-1);
            return;
        }
        tem.add(candidates[index]);
        pre = candidates[index];
        dfs(target - candidates[index], tem, index+1, candidates, pre);
    }
}
