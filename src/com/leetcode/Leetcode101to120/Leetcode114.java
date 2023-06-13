package com.leetcode.Leetcode101to120;

import com.leetcode.tool.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
    思路：使用队列存储树前序遍历的结果，然后将节点依次
    拼接成队列，注意在存储时要将树原本的结构消除
 */
public class Leetcode114 {
    Queue<TreeNode> queue = new LinkedList<>();
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        } else {
            preOrder(root);
        }
        TreeNode preNode = queue.poll();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            preNode.right = node;
            preNode = preNode.right;
        }

    }
    public void preOrder(TreeNode root) {
        queue.offer(root);
        if (root.left != null) {
            TreeNode left = root.left;
            root.left = null;
            preOrder(left);
        }
        if (root.right != null) {
            TreeNode right = root.right;
            root.right = null;
            preOrder(right);
        }
    }
}
