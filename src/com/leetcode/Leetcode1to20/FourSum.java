package com.leetcode.core.oneToTwenty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }
        int left, right;
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 3; first++) {
            if (first > 0 && nums[first] == nums[first-1]) {
                continue;
            }
            for (int second = first + 1; second < nums.length - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second-1]) {
                    continue;
                }
                left = second + 1;
                right = nums.length - 1;
                while (left < right) {
                    long men = nums[first] + nums[second] + nums[left] + nums[right];
                    if (men == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[first]);
                        temp.add(nums[second]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        res.add(temp);
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left-1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right+1]) {
                            right--;
                        }
                    } else if (men < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
