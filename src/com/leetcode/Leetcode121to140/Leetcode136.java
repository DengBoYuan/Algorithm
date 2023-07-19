package com.leetcode.Leetcode121to140;

import java.util.Arrays;

public class Leetcode136 {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        boolean flag = true;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i-1]) {
                flag = false;
            } else {
                if (flag) {
                    return nums[i-1];
                } else {
                    flag = true;
                }
            }
        }
        return nums[len-1];
    }
}
