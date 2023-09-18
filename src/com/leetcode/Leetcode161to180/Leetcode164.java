package com.leetcode.Leetcode161to180;

import java.util.Arrays;

public class Leetcode164 {
    public int maximumGap(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int maxVal = Arrays.stream(nums).max().getAsInt();
        int minVal = Arrays.stream(nums).min().getAsInt();
        int d = Math.max(1, (maxVal-minVal) / (len-1));
        int bucketSize = (maxVal-minVal) / d + 1;
        int[][] bucket = new int[bucketSize][2];
        for (int i = 0; i < bucketSize; i++) {
            Arrays.fill(bucket[i], -1);
        }
        for (int i = 0; i < len; i++) {
            int index = (nums[i] - minVal) / d;
            if (bucket[index][0] == -1) {
                bucket[index][0] = bucket[index][1] = nums[i];
            } else {
                bucket[index][0] = Math.min(bucket[index][0], nums[i]);
                bucket[index][1] = Math.max(bucket[index][1], nums[i]);
            }
        }
        int ret = 0;
        int prev = -1;
        for (int i = 0; i < bucketSize; i++) {
            if (bucket[i][0] == -1) {
                continue;
            }
            if (prev != -1) {
                ret = Math.max(ret, bucket[i][0] - bucket[prev][1]);
            }
            prev = i;
        }
        return ret;
    }
}
