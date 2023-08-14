package com.leetcode.Leetcode141to160;

import com.leetcode.tool.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (set.contains(p)) {
                return p;
            } else {
                set.add(p);
                p = p.next;
            }
        }
        return null;
    }
}
