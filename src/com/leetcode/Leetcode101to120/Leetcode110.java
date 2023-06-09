package com.leetcode.Leetcode101to120;

import com.leetcode.tool.TreeNode;

/*
    思路：使用一个函数求树的高度，然后判断树的每个节点的高度是否
    平衡
 */
public class Leetcode110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
        }
    }
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
}
