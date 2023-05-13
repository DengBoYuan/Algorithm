package com.leetcode.TwentyoneToFourty;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int temp = nums[0];
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != temp) {
                temp = nums[i];
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }
}
