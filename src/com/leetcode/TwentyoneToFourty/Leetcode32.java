package com.leetcode.TwentyoneToFourty;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    思路：首先初始化栈顶元素为-1作为初始边界，每出现‘（’索引入栈，‘）’索引出栈
    出栈后若栈为空则将当前元素索引入栈作为更新的边界，若非空则更新当前最大有效长
    度max为当前索引减去栈顶索引，并更新res为两者更大的数

    tips：java已经不推荐使用Stack类，用Deque接口代替，声明如下
    Deque<Integer> st = new ArrayDeque<>();
 */
public class Leetcode32 {
    public int longestValidParentheses(String s) {
        int res = 0;
        int len = s.length();
        int max = 0;
//        Stack<Integer> st = new Stack<>();
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1);
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                st.pop();
                if (!st.isEmpty()) {
                    max = i - st.peek();
                    res = Math.max(max, res);
                } else {
                    st.push(i);
                }
            }
        }
        return res;
    }
}
