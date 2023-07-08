package com.leetcode.Leetcode121to140;

import java.util.Arrays;

public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        int res = 1;
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] - nums[i-1] == 1) {
                count++;
            } else if (nums[i] == nums[i-1]) {
                continue;
            } else {
                res = Math.max(res, count);
                count = 1;
            }
        }
        res = Math.max(res, count);
        return res;
    }
}
