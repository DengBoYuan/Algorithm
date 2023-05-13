package com.leetcode.FourtyoneToSixty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
    思路：排序
        首先将二维数组按每个数组的第一个数（即每个区间的左边界）大小排序
        重叠的区间一定是相连的，所以先将第一个数组加入集合后，开始遍历，若当前
        区间的左边界大于集合最后一个数组的右边界，则直接将当前数组加入，否则
        更新集合最后一个数组的右边界，值为两者右边界最大值，然后继续遍历，直到
        最后一个，然后将集合转换为数组返回
 */
public class Leetcode56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        int len = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        list.add(intervals[0]);
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] > list.get(list.size()-1)[1]) {
                list.add(intervals[i]);
            } else {
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1], intervals[i][1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
