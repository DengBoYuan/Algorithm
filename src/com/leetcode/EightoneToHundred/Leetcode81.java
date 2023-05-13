package com.leetcode.EightoneToHundred;

/*
    思路：将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
         此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
         （当左等于右等于中间，则无法确定那一部分是有序的，此时需要左右移，右左移）
 */
public class Leetcode81 {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if (nums.length == 1) {
            return nums[0] == target;
        }
        while (left <= right) {
            int mid = (left+right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[mid] >= nums[left]){
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[nums.length-1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
