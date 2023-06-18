package com.leetcode.Leetcode121to140;

/*
    动态规划：由于最多交易两次，所以将所有交易日分为
    两个部分，最大利润就是两个部分最大利润和，遍历，
    ldp[i]表示从第一天到第i+1天可获得的最大利润，
    rdp[i]表示从第i+2天到最后一天可获得的最大利润，
    两个部分利润和最大的就是答案
 */
public class Leetcode123 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] ldp = new int[len];
        int[] rdp = new int[len];
        int res = 0;
        int left = prices[0], right = prices[len-1];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                continue;
            }
            if (i == len-1) {
                left = Math.min(left, prices[i]);
                ldp[i] += Math.max(ldp[i-1], prices[i] - left);
                continue;
            }
            left = Math.min(left, prices[i]);
            ldp[i] += Math.max(ldp[i-1], prices[i] - left);
            rdp[len-2-i] += Math.max(rdp[len-i-1], right - prices[len-1-i]);
            right = Math.max(right, prices[len-1-i]);
        }
        for (int i = 0; i < len; i++) {
            res = Math.max(res, ldp[i] + rdp[i]);
        }
        return res;
    }
}
