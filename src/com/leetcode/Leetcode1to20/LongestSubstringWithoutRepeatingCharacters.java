package com.leetcode.core.oneToTwenty;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int left = 0;
        int res = 0;
        Map<Character, Integer> counter = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            counter.put(s.charAt(right), counter.getOrDefault(s.charAt(right), 0) + 1);
            while (counter.get(s.charAt(right)) > 1){
                counter.put(s.charAt(left), counter.get(s.charAt(left)) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
