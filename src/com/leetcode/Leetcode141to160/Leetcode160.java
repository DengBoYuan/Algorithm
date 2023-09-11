package com.leetcode.Leetcode141to160;

import com.leetcode.tool.ListNode;

/*
    思路：双指针，令pa指向链表a，pb指向链表b，每次向后移动一位
    当移动到末尾，即pa或pb为null，则指向另一条链表，直到两个指针
    指向同一个节点，若不相交，则会同时指向对方链表的末尾，易证
 */
public class Leetcode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointA = headA;
        ListNode pointB = headB;
        while (pointA != pointB) {
            if (pointA == null) {
                pointA = headB;
            } else {
                pointA = pointA.next;
            }
            if (pointB == null) {
                pointB = headA;
            } else {
                pointB = pointB.next;
            }
        }
        return pointA;
    }
}
