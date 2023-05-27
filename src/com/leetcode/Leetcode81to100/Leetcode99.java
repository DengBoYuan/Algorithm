package com.leetcode.Leetcode81to100;

import com.leetcode.tool.TreeNode;

import java.util.LinkedList;

/*
    思路：中序遍历，若为二叉搜索树，则递增，所以若出现递减，
    则说明出现递减的两个数中前一个数的位置有问题，标记然后
    继续遍历，找出第一个大于标记位置的数，该数的前一个是第
    二个有问题的位置，若没有，则说明第二个有问题的位置在最
    后一个，然后标记，最后交换标记的两个位置的数
 */

public class Leetcode99 {
    public void recoverTree(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        int pre = Integer.MIN_VALUE;
        TreeNode preNode = null;
        TreeNode lNode = null, rNode = null;
        TreeNode iNode = root;
        while (iNode != null || !stack.isEmpty()) {
            if (iNode != null) {
                stack.push(iNode);
                iNode = iNode.left;
            } else {
                TreeNode node = stack.pop();
                if (node.val == pre) {
                    preNode = node;
                    iNode = node.right;
                    continue;
                }
                if (lNode == null) {
                    if (node.val > pre) {
                        pre = node.val;
                        preNode = node;
                        iNode = node.right;
                    } else {
                        lNode = preNode;
                        preNode = node;
                        iNode = node.right;
                    }
                } else {
                    if (node.val < lNode.val) {
                        preNode = node;
                        iNode = node.right;
                    } else {
                        rNode = preNode;
                        break;
                    }
                }
            }
        }
        if (rNode == null) {
            rNode = preNode;
        }
        int tem = lNode.val;
        lNode.val = rNode.val;
        rNode.val = tem;
    }
}
