package com.leetcode.Leetcode101to120;

import com.leetcode.tool.Node;

import java.util.LinkedList;
import java.util.Queue;

/*
    思路：首先层次遍历，然后每次队列中只有一层的时候
    记录个数，然后取出并添加next指针，同时把他们的
    子节点添加进队列
 */
public class Leetcode116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        if (root.left != null) {
            queue.offer(root.left);
        }
        if (root.right != null) {
            queue.offer(root.right);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
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
        }
        return root;
    }
}
