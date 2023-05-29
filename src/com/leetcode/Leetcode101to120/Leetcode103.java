package com.leetcode.Leetcode101to120;

import com.leetcode.tool.TreeNode;

import java.util.*;

/*
    思路：同102，使用队列进行层次遍历，但要在偶数层将
    列表翻转，使用Collections.reverse（）方法
 */
public class Leetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int flag = 1;
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode tem = queue.poll();
                list.add(tem.val);
                if (tem.left != null) {
                    queue.offer(tem.left);
                }
                if (tem.right != null) {
                    queue.offer(tem.right);
                }
            }
            if (flag == -1) {
                Collections.reverse(list);
            }
            res.add(list);
            flag = -flag;
        }
        return res;
    }
}
