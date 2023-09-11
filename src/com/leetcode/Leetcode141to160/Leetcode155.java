package com.leetcode.Leetcode141to160;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode155 {

    Deque<Integer> stack;
    Deque<Integer> minStack;

    public Leetcode155() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        if (val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int ele = stack.pop();
        if (ele == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
