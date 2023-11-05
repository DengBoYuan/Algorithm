package com.leetcode.Leetcode201to220;

import java.util.HashMap;
import java.util.Map;

/*
    思路：使用两个哈希表，一个存储s->t的映射，一个存储
    t->s的映射，然后从第一个字符开始遍历，若当前两个
    字符的映射和哈希表中的映射不同，则返回false，其他
    情况都设置映射
 */
public class Leetcode205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((map1.containsKey(x) && map1.get(x) != y) || (map2.containsKey(y) && map2.get(y) != x)) {
                return false;
            }
            map1.put(x, y);
            map2.put(y, x);
        }
        return true;
    }
}
