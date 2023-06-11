package com.leetcode.Leetcode101to120;

import com.leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
    思路：代码回溯：每次遍历到叶子节点则判断当前值是否与所需值
    相等，若相等，则添加当前节点后加入结果集，否则直接返回，若
    不是叶子节点，则添加当前节点，然后有左就向左遍历，有右就向
    右遍历
 */
public class Leetcode113 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        dfs(root, targetSum, new ArrayList<>());
        return res;
    }
    public void dfs(TreeNode root, int targetSum, List<Integer> list) {
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                res.add(list);
            }
            return;
        }
        list.add(root.val);
        if (root.left != null) {
            dfs(root.left, targetSum - root.val, new ArrayList<>(list));
        }
        if (root.right != null) {
            dfs(root.right, targetSum - root.val, new ArrayList<>(list));
        }
    }
}
