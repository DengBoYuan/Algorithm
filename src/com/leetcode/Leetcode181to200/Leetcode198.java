package com.leetcode.Leetcode181to200;


/*
    思路：动态规划，dp[i]存储前i间房可以偷的最大金额
    然后dp[i]= max(dp[i-2] + nums[i], dp[i-1])，因为
    增加第i间房，要么是i-2间房最大的加上i间房，要么是i-1间
    房最大的，最后返回dp[n-1]
 */
public class Leetcode198 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[n-1];
    }
}
