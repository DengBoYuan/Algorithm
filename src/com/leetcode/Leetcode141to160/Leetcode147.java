package com.leetcode.Leetcode141to160;

import com.leetcode.tool.ListNode;

public class Leetcode147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            if (cur.val < pre.val) {
                pre.next = cur.next;
                if (cur.val < head.val) {
                    cur.next = head;
                    head = cur;
                } else {
                    ListNode p = head;
                    ListNode c = head.next;
                    while (true) {
                        if (c.val >= cur.val) {
                            p.next = cur;
                            cur.next = c;
                            break;
                        }
                        p = p.next;
                        c = c.next;
                    }
                }
                cur = pre.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return head;
    }
}
