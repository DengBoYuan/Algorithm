package com.leetcode.core.oneToTwenty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        HashMap<Character, String> list = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        if (digits.length() == 0) {
            return res;
        }
        list.put('2', "abc");
        list.put('3', "def");
        list.put('4', "ghi");
        list.put('5', "jkl");
        list.put('6', "mno");
        list.put('7', "pqrs");
        list.put('8', "tuv");
        list.put('9', "wxyz");
        combine(res, list, sb, 0, digits);
        return res;
    }
    public void combine(List<String> res, HashMap<Character, String> list, StringBuffer sb, int index, String digits) {
        if (index == digits.length()) {
            res.add(sb.toString());
        } else {
            String digit = list.get(digits.charAt(index));
            for (int j = 0; j < digit.length(); j++) {
                sb.append(digit.charAt(j));
                combine(res, list, sb, (index + 1), digits);
                sb.deleteCharAt(index);
            }
        }
    }
}
