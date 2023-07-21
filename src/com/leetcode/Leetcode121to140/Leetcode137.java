package com.leetcode.Leetcode121to140;

public class Leetcode137 {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                sum += (nums[j] >> i & 1);
            }
            if (sum % 3 != 0) {
                res |= 1 << i;
            }
        }
        return res;
    }
}
