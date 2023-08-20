package com.leetcode.Leetcode141to160;

import com.leetcode.tool.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode143 {
    public void reorderList(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        ListNode p = head.next;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        ListNode cur = head;
        int flag = 1;
        while (!stack.isEmpty()) {
            if (flag == 1) {
                ListNode node = stack.getFirst();
                cur.next = node;
                cur = cur.next;
                stack.removeFirst();
            } else {
                ListNode node = stack.getLast();
                cur.next = node;
                cur = cur.next;
                stack.removeLast();
            }
            flag = -flag;
        }
        cur.next = null;
    }
}
