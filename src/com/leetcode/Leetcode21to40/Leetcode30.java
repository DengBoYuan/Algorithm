package com.leetcode.Leetcode21to40;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
思路：滑动窗口加哈希表
    创建一个word表记录words数组各字符串出现次数，在使用滑动窗口
    框住长度为串联子串长度的字符串，创建一个tem表记录该字符串中各
    字符串出现次数，若两表相同，则记录当前位置
 */
public class Leetcode30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        HashMap<String, Integer> wordMap = new HashMap<>();
        int wLen = words[0].length();
        int wNum = words.length;
        int allLen = wLen * wNum;
        for (int i = 0; i < wNum; i++) {
            wordMap.put(words[i], wordMap.getOrDefault(words[i], 0) + 1);
        }
        for (int j = 0; j <= s.length() - allLen; j++) {
            HashMap<String, Integer> tem = new HashMap<>();
            for (int k = 0; k < wNum; k++) {
                tem.put(s.substring(j + k * wLen, j + (k+1) * wLen), tem.getOrDefault(s.substring(j + k * wLen, j + (k+1) * wLen), 0) + 1);
            }
            if (wordMap.equals(tem)) {
                res.add(j);
            }
        }
        return res;
    }

}
