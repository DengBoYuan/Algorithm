package com.leetcode.Leetcode61to80;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
    思路：滑动窗口，使用两个哈希表，一个记录子串字符及其个数，另一个
    记录当前字符串与子串相同的字符的个数，当当前的所有字符个数大于子串
    所有字符个数，则全覆盖，使用left，right记录当前字符串，一直右移right
    直到全覆盖，若当前最小则记录，然后右移left压缩当前字符串直到不覆盖，然后
    继续右移right，直到right到末尾，输出当前最小字符串
 */
public class Leetcode76 {
    public String minWindow(String s, String t) {
        int left = 0, right = 0;
        int mlen = Integer.MAX_VALUE;
        int start = -1, end = -1;
        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> smap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (tmap.containsKey(s.charAt(i))) {
                left = i;
                right = i;
                break;
            }
        }
        while (right < s.length()) {
            if (tmap.containsKey(s.charAt(right))) {
                smap.put(s.charAt(right), smap.getOrDefault(s.charAt(right), 0) + 1);
            }
            while (check(tmap, smap) && left <= right) {
                if (right - left + 1 < mlen) {
                    mlen = right - left + 1;
                    start = left;
                    end = right;
                }
                if (smap.containsKey(s.charAt(left))) {
                    smap.put(s.charAt(left), smap.getOrDefault(s.charAt(left), 0) - 1);
                }
                left++;
            }
            right++;
        }
        return start == -1 ? "" : s.substring(start, end + 1);
    }
    public boolean check(Map<Character, Integer> tmap, Map<Character, Integer> smap) {
        Iterator iter = tmap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (smap.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}
