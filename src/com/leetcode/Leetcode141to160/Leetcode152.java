package com.leetcode.Leetcode141to160;

/*
    思路：动态规划，maxF表示以前一个下标结尾的最大乘积
    minF表示最小乘积，当前下标i的最大值等于maxF * num[i]，
    minF * num[i],num[i]三者中最大的（若num[i]为正，
    则maxF为num[i]或num[i]*上一个maxF，易证），同理
    当前最小值为用minF替换maxF的三者最小值，最后返回最大值
 */
public class Leetcode152 {
    public int maxProduct(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }
}
