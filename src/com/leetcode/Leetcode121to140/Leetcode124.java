package com.leetcode.Leetcode121to140;

import com.leetcode.tool.TreeNode;

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
