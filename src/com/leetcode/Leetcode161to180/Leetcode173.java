package com.leetcode.Leetcode161to180;

import com.leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
    思路：创建一个集合用于存储中序遍历后的结果，然后设置一个全局变量用于
    代表当前指针，然后每次调用next时，将当前指针指向的数字返回，然后+1
    hasNext则判断当前是否超出集合长度
 */
public class Leetcode173 {

    private int point = 0;
    private List<Integer> arr;

    public Leetcode173(TreeNode root) {
        arr = new ArrayList<>();
        TreeNode p = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode tem = stack.pop();
                arr.add(tem.val);
                p = tem.right;
            }
        }
    }

    public int next() {
        int res = arr.get(point);
        point++;
        return res;
    }

    public boolean hasNext() {
        if (point < arr.size()) {
            return true;
        } else {
            return false;
        }
    }
}
