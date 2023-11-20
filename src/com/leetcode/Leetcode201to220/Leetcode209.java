package com.leetcode.Leetcode201to220;

/*
    思路：滑动窗口，sum记录窗口中的总和，当sum大于等于target时，
    left左移知道小于，小于时就right右移，记录最短子串
 */
public class Leetcode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int res = n + 1, sum = 0;
        int left = 0, right = 0;
        while (right < n) {
            sum += nums[right];
            while (sum >= target) {
                if (right - left + 1 == 1) {
                    return 1;
                }
                res = Math.min(res, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return res == n+1 ? 0 : res;
    }
}
