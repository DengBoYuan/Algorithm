package com.leetcode.Leetcode101to120;

import com.leetcode.tool.TreeNode;

/*
    思路：递归，从根节点开始向下搜索，若为null，返回0，若
    为叶子节点（即左右均为null），返回1，若左为null，返回
    右子树最小高度+1，右为null，返回左子树最小高度+1，均
    不为null则返回左右最小高度中更小的+1
 */
public class Leetcode111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
