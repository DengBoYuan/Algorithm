package com.leetcode.core.oneToTwenty;


import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
