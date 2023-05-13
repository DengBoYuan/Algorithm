package com.leetcode.core.oneToTwenty;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    算法思想：排序加双指针：
    先将数组排序，然后遍历数组作为第一个数，若大于0，则停止遍历，再使用两个
    指针（下标）指向第二个和第三个数，第三个数从最后开始，第二个数从第一个数
    的下一个开始，若三个数遇到相同的就跳过，直到二三数相遇，当三个数和为0时添
    加进结果中
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int left, right;
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            if ((k-1) >= 0 && nums[k] == nums[k-1]) {
                continue;
            }
            left = k + 1;
            right = nums.length - 1;
            if (nums[k] > 0) {
                return res;
            }
            while (left < right) {
                if ((nums[k] + nums[left] + nums[right]) == 0) {
                    List<Integer> mem = new ArrayList<>();
                    mem.add(nums[k]);
                    mem.add(nums[left]);
                    mem.add(nums[right]);
                    res.add(mem);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right+1]) {
                        right--;
                    }
                } else if ((nums[k] + nums[left] + nums[right]) > 0) {
                    right--;
                    while (left < right && nums[right] == nums[right+1]) {
                        right--;
                    }
                } else {
                    left++;
                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                }
            }
        }
        return res;
    }
}

