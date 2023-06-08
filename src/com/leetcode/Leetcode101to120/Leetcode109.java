package com.leetcode.Leetcode101to120;

import com.leetcode.tool.ListNode;
import com.leetcode.tool.TreeNode;

/*
    思路：同108，首先遍历链表，记录长度，然后每次取最中间的
    作为根
 */
public class Leetcode109 {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return build(head, count);
    }
    public TreeNode build(ListNode head, int length) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode();
        pre.next = head;
        int index = (length+1)/2;
        ListNode node = head;
        TreeNode treeNode = new TreeNode();
        int count = 0;
        while (node != null) {
            count++;
            if (count == index) {
                break;
            }
            node = node.next;
            pre = pre.next;
        }
        treeNode.val = node.val;
        if (node == head) {
            treeNode.left = build(null, 0);
        } else {
            pre.next = null;
            treeNode.left = build(head, count-1);
        }
        treeNode.right = build(node.next, length-count);
        return treeNode;
    }
}
