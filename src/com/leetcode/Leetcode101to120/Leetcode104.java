package com.leetcode.Leetcode101to120;

import com.leetcode.tool.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/*
    思路：层次遍历，每遍历一层深度加一
 */
public class Leetcode104 {
    public int maxDepth(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        int res = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode tem = queue.poll();
                if (tem.left != null) {
                    queue.offer(tem.left);
                }
                if (tem.right != null) {
                    queue.offer(tem.right);
                }
            }
            res++;
        }
        return res;
    }
}
