package com.leetcode.Leetcode21to40;

public class Leetcode35 {
    public int searchInsert(int[] nums, int target) {
        int res = 0;
        int len = nums.length;
        int left = 0, right = len - 1;
        if (len == 0) {
            return res;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] >= target) {
            res = left;
        } else {
            res = left + 1;
        }
        return res;
    }
}
