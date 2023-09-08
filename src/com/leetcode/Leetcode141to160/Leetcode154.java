package com.leetcode.Leetcode141to160;

public class Leetcode154 {
    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 1 || nums[len-1] < nums[0]) {
            return nums[0];
        }
        int left = 0, right = len-1;
        while (right > left) {
            if (right == left + 1) {
                return Math.min(nums[left], nums[right]);
            }
            if (nums[right] > nums[left]) {
                return nums[left];
            }
            int mid = (left + right) / 2;
            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[mid] >= nums[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
