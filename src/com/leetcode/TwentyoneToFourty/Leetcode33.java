package com.leetcode.TwentyoneToFourty;

public class Leetcode33 {
    public int search(int[] nums, int target) {
        int res = -1;
        int left = 0, right = nums.length - 1;
        int flag = 1;
        if (target == nums[0]) {
            return 0;
        } else if (target > nums[0]) {
            flag = -1;
        }
        if (nums[0] < nums[nums.length - 1]) {
            flag = 0;
        }
        if (flag == 1) {
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    res = mid;
                    break;
                } else if (nums[mid] < target || (nums[mid] > nums[right] && nums[left] > nums[right])) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        } else if (flag == -1){
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    res = mid;
                    break;
                } else if (nums[mid] > target || (nums[mid] < nums[right] && nums[left] > nums[right])) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        } else {
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    res = mid;
                    break;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return res;
    }
}
