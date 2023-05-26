package com.leetcode.Leetcode61to80;

import java.util.ArrayList;
import java.util.List;

/*
    思路：递归实现回溯+剪枝，从1开始往集合中添加数，每添加一个
    继续添加比上一个数大1的数，当集合的长度等于所需长度时，
    将其添加进结果集中，同时剪枝:当集合加上之后的所有数的长度
    仍不足以达到所需长度，则直接返回
 */
public class Leetcode77 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return res;
    }
    public void dfs(int n ,int k, int i) {
        if (list.size() + n - i + 1 < k) {
            return;
        }
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j <= n; j++) {
            list.add(j);
            dfs(n, k, j+1);
            list.remove(list.size()-1);
        }
    }
}
