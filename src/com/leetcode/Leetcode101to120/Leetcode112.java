package com.leetcode.Leetcode101to120;

import com.leetcode.tool.TreeNode;

/*
    思路：递归，当节点为空时，直接返回false，当节点为叶子节点时
    若节点值与目标值相同，返回true，否则返回false，若不是叶子
    节点，则将左右子节点还有目标值减去当前值作为参数递归，满足
    左右子树其中一个则为true，否则为false
 */
public class Leetcode112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                return true;
            } else {
                return false;
            }
        } else {
            return hasPathSum(root.right, targetSum - root.val) || hasPathSum(root.left, targetSum - root.val);
        }
    }
}
