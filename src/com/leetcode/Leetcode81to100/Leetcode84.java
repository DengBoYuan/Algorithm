package com.leetcode.Leetcode81to100;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    思路：单调栈（单调栈是栈中数据有单调性的栈）：用两个数组
    存储第i个位置的左右两边第一个小于i的值的位置（若左边无则
    取-1，右边无则取heights.length）；用栈存储遍历时左边和
    右边可能作为第一个小于i的值的位置，栈要单调递增，若当前位置
    小于栈顶，则弹出栈顶，直到单调
 */
public class Leetcode84 {
    public int largestRectangleArea(int[] heights) {
        int res = -1;
        int len = heights.length;
        int[] lmin = new int[len];
        int[] rmin = new int[len];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && heights[deque.peek()] >= heights[i]) {
                deque.pop();
            }
            lmin[i] = deque.isEmpty() ? -1 : deque.peek();
            deque.push(i);
        }
        deque.clear();
        for (int i = len-1; i >= 0; i--) {
            while (!deque.isEmpty() && heights[deque.peek()] >= heights[i]) {
                deque.pop();
            }
            rmin[i] = deque.isEmpty() ? len : deque.peek();
            deque.push(i);
        }
        for (int i = 0; i < len; i++) {
            res = Math.max(res, (rmin[i] - lmin[i] - 1) * heights[i]);
        }
        return res;
    }
}
