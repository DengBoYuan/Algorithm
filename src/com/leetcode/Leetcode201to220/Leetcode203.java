package com.leetcode.Leetcode201to220;

import com.leetcode.tool.ListNode;

public class Leetcode203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode hair = new ListNode();
        ListNode pre = hair;
        pre.next = head;
        ListNode p = head;
        while (p != null) {
            if (p.val == val) {
                p = p.next;
                continue;
            }
            pre.next = p;
            pre = pre.next;
            p = p.next;
        }
        pre.next = null;
        return hair.next;
    }
}
