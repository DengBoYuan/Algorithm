package com.leetcode.Leetcode101to120;

import com.leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


/*
    思路：同102，二叉树的层次遍历，输出与102相反，所以先使用栈存储结果的集合，
    然后弹出存储
 */
public class Leetcode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<List<Integer>> stack = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            stack.push(list);
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
}
