package com.leetcode.Leetcode201to220;

import java.util.HashMap;
import java.util.Map;

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
