package com.leetcode.Leetcode181to200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    思路：使用哈希表存储子串出现次数，将大于2的存入集合
 */
public class Leetcode187 {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len <= 10) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        int left = 0, right = 10;
        while (right <= len) {
            String p = s.substring(left, right);
            map.put(p, map.getOrDefault(p, 0) + 1);
            if (map.get(p) == 2) {
                res.add(p);
            }
            left++;
            right++;
        }
        return res;
    }
}
