package com.leetcode.Leetcode121to140;

import com.leetcode.tool.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode129 {
    int res = 0;
    public int sumNumbers(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                if (cur.left == null && cur.right == null) {
                    res += cur.val;
                }
                if (cur.left != null) {
                    cur.left.val += cur.val * 10;
                }
                if (cur.right != null) {
                    cur.right.val += cur.val * 10;
                }
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop().right;
            }
        }
        return res;
    }
}
