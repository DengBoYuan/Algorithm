package com.leetcode.Leetcode101to120;

import com.leetcode.tool.TreeNode;


/*
    思路：递归，对称即左子树的左等于右子树的右，左子树的右等于右子树的左
 */
public class Leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }
    public boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return dfs(p.left, q.right) && dfs(p.right, q.left);
    }
}
