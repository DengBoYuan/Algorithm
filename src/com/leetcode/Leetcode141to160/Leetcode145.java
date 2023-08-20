package com.leetcode.Leetcode141to160;

import com.leetcode.tool.TreeNode;

import java.util.*;


public class Leetcode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();
            if (node.right == null || node.right == lastVisit) {
                node = stack.pop();
                res.add(node.val);
                lastVisit = node;
                node = null;
            } else {
                node = node.right;
            }
        }
        return res;
    }
}
