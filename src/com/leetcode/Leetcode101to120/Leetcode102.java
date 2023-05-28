package com.leetcode.Leetcode101to120;

import com.leetcode.tool.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
    思路:广度优先算法（BFS），使用队列存储节点，首先将根节点存入
    然后判断队列是否为空，不为空则进入循环，每次进入循环记录此时队列中的
    节点数，这个就是同一层次的节点，然后将这些同一层次的节点依次
    遍历，并存储到集合中，每个节点的左右节点都存入队列，全部遍历
    完就完成
 */
public class Leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            res.add(new ArrayList<>());
            return res;
        }
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
            res.add(list);
        }
        return res;
    }
}
