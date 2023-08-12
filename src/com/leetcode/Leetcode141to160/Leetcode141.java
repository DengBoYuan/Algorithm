package com.leetcode.Leetcode141to160;

import com.leetcode.tool.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode141 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode point = head;
        while (point != null) {
            if (set.contains(point)) {
                return true;
            } else {
                set.add(point);
                point = point.next;
            }
        }
        return false;
    }
}
