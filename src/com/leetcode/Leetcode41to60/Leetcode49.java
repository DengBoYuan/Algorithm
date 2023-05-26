package com.leetcode.Leetcode41to60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
    思路：将数组的每个字符串转成字符数组排序，将排序后相同
        的字符串用一个哈希表存，key是排序后的字符串，value是
        相同的字符串的集合，最后返回由value组成的集合
 */
public class Leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(key);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
