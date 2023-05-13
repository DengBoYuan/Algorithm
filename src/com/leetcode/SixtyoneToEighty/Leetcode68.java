package com.leetcode.SixtyoneToEighty;

import java.util.ArrayList;
import java.util.List;

/*
    思路：模拟：
            先找出每行可以放的单词的最大数量（每个单词之间至少有一个空格）
            然后判断每个单词间平均放几个空格（有余数的从左往右依次放一个）
            其中最后一行为左对齐，所以每个单词间一个空格，最后用空格填满
 */
public class Leetcode68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int len = words.length;
        StringBuffer sb = new StringBuffer();
        List<String> res = new ArrayList<>();
        int width = 0, start = 0, count = 0;
        for (int i = 0; i < len; i++) {
            if (words[i].length() + width + Math.max(0, count) <= maxWidth) {
                width += words[i].length();
                count++;
                if (i == len-1) {
                    for (int j = start; j < i; j++) {
                        sb.append(words[j]);
                        sb.append(' ');
                    }
                    sb.append(words[len-1]);
                    for (int k = 0; k < (maxWidth - width - count + 1); k++) {
                        sb.append(' ');
                    }
                    res.add(sb.toString());
                    break;
                }
            } else {
                if (count == 1) {
                    sb.append(words[i-1]);
                    for (int j = 0; j < maxWidth-width; j++) {
                        sb.append(' ');
                    }
                } else {
                    int blankNum = (maxWidth - width) / (count - 1);
                    int extraBlank = (maxWidth - width) % (count - 1);
                    for (int j = start; j < i - 1; j++) {
                        sb.append(words[j]);
                        for (int k = 0; k < blankNum; k++) {
                            sb.append(' ');
                        }
                        if (extraBlank > 0) {
                            sb.append(' ');
                            extraBlank--;
                        }
                    }
                    sb.append(words[i-1]);
                }
                res.add(sb.toString());
                sb.delete(0, maxWidth);
                width = 0;
                start = i;
                count = 0;
                i--;
            }
        }
        return res;
    }
}
