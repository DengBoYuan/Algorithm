package com.leetcode.FourtyoneToSixty;

public class Leetcode41 {
    public int firstMissingPositive(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            } else if (Math.abs(nums[i]) <= nums.length) {
                nums[nums[i] - 1] = -Math.abs(nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return res;
    }
}
