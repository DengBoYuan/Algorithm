package com.leetcode.Leetcode121to140;

/*
    思路：遍历，使用buy存储到当前位置为止的最低价格，
    res存储最大收益若当前位置价格比buy小，则更新buy，
    否则判断当前位置卖出的收益是否小于res，若小于，更
    新res，否则不动
 */
public class Leetcode121 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else {
                res = Math.max(res, prices[i] - buy);
            }
        }
        return res;
    }
}
