package com.leetcode.core.oneToTwenty;

import java.util.Arrays;

/*
    算法思想：排序加双指针
    将数组排序，然后遍历数组作为第一个数，然后使用两个指针（下标）
    作为第二和第三个数，记录当前三数和，与目标值比较，更小就左指针
    右移，更大就右指针左移，并记录差值，最后将差值最小的输出
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int len = nums.length;
        int minDif = Integer.MAX_VALUE;
        if (len == 3) {
            res = nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                if (temp == target) {
                    return temp;
                }
                if (Math.max(target, temp) - Math.min(target, temp) < minDif ) {
                    minDif = Math.max(target, temp) - Math.min(target, temp);
                    res = temp;
                }
                if (temp > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
