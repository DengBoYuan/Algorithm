package com.leetcode.EightoneToHundred;

import java.util.ArrayList;
import java.util.List;

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


/*
    思路：递归回溯，二分搜索树的左子树小于根，右子树大于根
    所以遍历（start，end）用i作为根，然后将（start，i-1）组成
    的左子树集合，（i+1，end）作为右子树集合，然后将左右子树集合
    遍历组合，结果返回，开始用（1，n）作为起始，当start > end
    时，说明这种情况没有结果，就直接添加null
 */
public class Leetcode95 {
    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }
    public List<TreeNode> dfs(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = dfs(start, i-1);
            List<TreeNode> rightNodes = dfs(i+1, end);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
