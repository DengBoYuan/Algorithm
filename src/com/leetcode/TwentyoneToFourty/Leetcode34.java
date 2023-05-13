package com.leetcode.TwentyoneToFourty;

/*
    思路：通过二分查找找出第一个大于等于target值的索引，若相等
    则为第一个值，否则返回初始值，然后再一次二分查找找出第一个大于target值的索引，减一
    作为最后一个值，然后返回
 */
public class Leetcode34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int len = nums.length;
        int left = 0, right = len - 1;
        int first = 0, last = 0;
        if (len == 0 || nums[left] > target || nums[right] < target) {
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
        if (nums[left] == target) {
            first = left;
        } else if (left <= len - 2 && nums[left+1] == target) {
            first = left + 1;
        } else {
            return res;
        }
        left = 0;
        right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (nums[right] == target) {
            last = right;
        } else {
            last = right - 1;
        }
        res[0] = first;
        res[1] = last;
        return res;
    }
}
