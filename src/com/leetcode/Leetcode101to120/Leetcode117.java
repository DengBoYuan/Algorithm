package com.leetcode.Leetcode101to120;

import com.leetcode.tool.Node;

import java.util.LinkedList;
import java.util.Queue;

/*
    思路：同116
 */
public class Leetcode117 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > 1) {
                Node pre = queue.poll();
                if (pre.left != null) {
                    queue.offer(pre.left);
                }
                if (pre.right != null) {
                    queue.offer(pre.right);
                }
                for (int i = 1; i < size; i++) {
                    Node node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    pre.next = node;
                    pre = node;
                }
            } else {
                Node n = queue.poll();
                if (n.left != null) {
                    queue.offer(n.left);
                }
                if (n.right != null) {
                    queue.offer(n.right);
                }
            }
        }
        return root;
    }
}
