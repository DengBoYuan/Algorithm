package com.leetcode.Leetcode41to60;

import java.util.ArrayList;
import java.util.List;

public class Leetcode57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int len = intervals.length;
        int sta = -1, end = len - 1;
        for (int i = 0; i < len; i++) {
            list.add(intervals[i]);
        }
        if (len == 0) {
            list.add(newInterval);
            return list.toArray(new int[list.size()][]);
        }
        if (newInterval[0] > intervals[len-1][1]) {
            list.add(newInterval);
            return list.toArray(new int[list.size()][]);
        }
        if (newInterval[1] < intervals[0][0]) {
            list.add(0, newInterval);
            return list.toArray(new int[list.size()][]);
        }
        for (int i = 0; i < len; i++) {
            if (newInterval[0] <= intervals[i][1]) {
                sta = i;
                break;
            }
        }
        for (int j = sta + 1; j < len; j++) {
            if (newInterval[1] < intervals[j][0]) {
                end = j - 1;
                break;
            }
        }
        if (sta == end && newInterval[1] < intervals[sta][0]) {
            list.add(sta, newInterval);
            return list.toArray(new int[list.size()][]);
        }
        newInterval[0] = Math.min(newInterval[0], intervals[sta][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[end][1]);
        for (int i = 0; i < end - sta + 1; i++) {
            list.remove(sta);
        }
        list.add(sta, newInterval);
        return list.toArray(new int[list.size()][]);
    }
}
