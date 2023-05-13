package com.leetcode.SixtyoneToEighty;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    思路：首先使用split方法将路径用'/'分隔开，并组成字符串数组
    然后遍历字符串数组，当前是".."则栈弹出栈顶元素，为空或为'.'
    则不动，其余的都将此字符串加入栈中，最后依次将栈中元素逆序输出
    并使用'/'隔开
 */
public class Leetcode71 {
    public String simplifyPath(String path) {
        String[] tem = path.split("/");
        Deque<String> dq = new ArrayDeque<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < tem.length; i++) {
            if (tem[i].equals("..")) {
                if (!dq.isEmpty()) {
                    dq.pop();
                }
            } else if (tem[i].equals(".") || tem[i].equals("")) {
                continue;
            } else {
                dq.push(tem[i]);
            }
        }
        while (!dq.isEmpty()) {
            sb.insert(0, dq.pop());
            sb.insert(0, '/');
        }
        if (sb.length() == 0) {
            sb.append('/');
        }
        return sb.toString();
    }
}
