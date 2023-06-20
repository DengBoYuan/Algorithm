package com.leetcode.Leetcode121to140;

import com.leetcode.tool.TreeNode;

/*
    思路：递归，对于每个节点，路径有以下情况：
    节点本身，节点左右子树或两个中更大的一个，还有
    父节点这几个的组合，而带父节点相当于它的父节点
    中子节点的情况，所以忽略，然后递归，每次返回节
    点最大贡献值，即以该节点为头的路径最大值，在递归
    过程中维护一个全局遍历res表示当前遇到的最大路径
    和
 */
public class Leetcode124 {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        int path = root.val + left + right;
        res = Math.max(res, path);
        return root.val + Math.max(left, right);
    }
}
