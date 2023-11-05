package com.leetcode.Leetcode201to220;

import com.leetcode.tool.ListNode;

public class Leetcode206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        ListNode nex = cur.next;
        head.next = null;
        while (cur != null) {
            cur.next = head;
            head = cur;
            cur = nex;
            nex = nex == null ? null : nex.next;
        }
        return head;
    }
}
