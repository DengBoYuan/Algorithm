package com.leetcode.Leetcode181to200;

import com.leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    思路：使用二叉树层序遍历的方法，每层先遍历最右边的节点
    然后将每层的第一个节点的值加入结果集中
 */
public class Leetcode199 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tem = queue.poll();
                if (i == 0) {
                    res.add(tem.val);
                }
                if (tem.right != null) {
                    queue.offer(tem.right);
                }
                if (tem.left != null) {
                    queue.offer(tem.left);
                }
            }
        }
        return res;
    }
}
