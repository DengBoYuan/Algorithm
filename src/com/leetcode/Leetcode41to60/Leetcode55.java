package com.leetcode.Leetcode41to60;

/*
    思路：贪心
 */
public class Leetcode55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maxEnd = 0;
        for (int i = 0; i < len && maxEnd >= i; i++) {
            maxEnd = Math.max(maxEnd, i + nums[i]);
            if (maxEnd >= len - 1){
                return true;
            }
        }
        return false;
    }
}
