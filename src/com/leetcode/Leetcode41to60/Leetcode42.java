package com.leetcode.Leetcode41to60;

public class Leetcode42 {
    public int trap(int[] height) {
        int len = height.length;
        int res = 0;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        int lmax = height[0];
        int rmax = height[len-1];
        for (int i = 0; i < len; i++) {
            leftMax[i] = Math.max(lmax, height[i]);
            rightMax[i] = Math.max(rmax, height[len-1-i]);
            lmax = Math.max(lmax, height[i]);
            rmax = Math.max(rmax, height[len-1-i]);
        }
        for (int i = 0; i < len; i++) {
            int tem = Math.min(leftMax[i], rightMax[i]) - height[i];
            res -= tem;
        }
        return res;
    }
}
