package com.leetcode.Leetcode221to240;

import java.util.Deque;
import java.util.LinkedList;

/*
    思路：维护一个单调队列（具有单调性的队列，首先遍历窗口中，当
    队列为空时，直接将当前下标加入队列，若非空，则将队列前小于当
    前值的全部移出队列（因为这些数此时不可能成为最大值了），然后
    将下标加入队列，当完成一个窗口后，队头即窗口最大值，之后同理
    ，只是每次窗口右移，若队头是此次滑出窗口的，就先移除
 */
public class Leetcode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len-k+1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }
        res[0] = nums[queue.getFirst()];
        for (int i = k; i < len; i++) {
            if (queue.getFirst() == i-k) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && nums[i] >= nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
            res[i-k+1] = queue.getFirst();
        }
        return res;
    }
}
