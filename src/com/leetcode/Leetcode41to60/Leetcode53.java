package com.leetcode.Leetcode41to60;

/*
    思路：一.双指针从两边向中间：
        1.若两头开始为负，则将两头值作为当前总和及当前最大
        然后向中间移动，将所指值与当前最大比较，大的作为新的
        当前最大，若所指值为负，则作为当前总和，为正则0作为
        当前总和，之后与开始为正一样
        2.若两头开始为正，则将0作为当前总和，然后加上所指值与
        当前最大比较，大的作为当前最大，若总和为负，舍弃，将
        0作为总和继续遍历

        二.动态规划：
        用f（i）作为以i为结尾的子串最大和，f（i）=Math.max(f(i-1)+nums[i], nums[i])
        使用pre记录上一个最大和（即f（i-1）），最后返回最大的f（i）
        class Solution {
            public int maxSubArray(int[] nums) {
                int pre = 0, maxAns = nums[0];
                for (int x : nums) {
                    pre = Math.max(pre + x, x);
                    maxAns = Math.max(maxAns, pre);
                }
                return maxAns;
            }
        }
 */
public class Leetcode53 {
    public int maxSubArray(int[] nums) {
        int res = 0;
        int len = nums.length;
        int left = 0, right = len - 1;
        int leftSum = Math.min(nums[0], 0), rightSum = Math.min(nums[len-1], 0);
        int leftMax = nums[0], rightMax = nums[len-1];
        if (len == 1) {
            return nums[0];
        }
        while (right > left) {
            if (leftSum < 0) {
                leftMax = Math.max(leftSum, nums[left]);
                leftSum = Math.min(nums[left], 0);
            } else {
                leftSum += nums[left];
                leftMax = Math.max(leftSum, leftMax);
                leftSum = Math.max(leftSum, 0);
            }
            if (rightSum < 0) {
                rightMax = Math.max(rightSum, nums[right]);
                rightSum = Math.min(nums[right], 0);
            } else {
                rightSum += nums[right];
                rightMax = Math.max(rightMax, rightSum);
                rightSum = Math.max(rightSum, 0);
            }
            left++;
            right--;
        }
        if (left == right) {
            leftSum = Math.max(leftSum, 0);
            rightSum = Math.max(rightSum, 0);
            res = Math.max(leftMax, Math.max(rightMax, leftSum+rightSum+nums[left]));
        } else {
            res = Math.max(leftMax, Math.max(rightMax, leftSum + rightSum));
        }
        return res;
    }
}
