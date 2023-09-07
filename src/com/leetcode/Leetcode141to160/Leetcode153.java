package com.leetcode.Leetcode141to160;

public class Leetcode153 {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1 || nums[0] < nums[n-1]) {
            return nums[0];
        }
        if (n == 2) {
            return Math.min(nums[0], nums[1]);
        }
        int left = 0, right = n-1;
        int mid = (left + right) / 2;
        while (right > left) {
            if (right == left + 1) {
                return Math.min(nums[left], nums[right]);
            }
            if (nums[mid] > nums[0]) {
                left = mid;
            } else {
                right = mid;
            }
            mid = (left + right) / 2;
        }
        return nums[left];
    }
}
