package com.leetcode.Leetcode121to140;

/*
    思路:方法一：每次在开始上涨的第一天买，最后一天卖
    使用一个标记，记录当前是处在寻找买点还是卖点，（
    先找买点，再找卖点，循环往复）若最后是找卖点，则将
    最后一天设为卖点
 */
public class Leetcode122 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int flag = 1;
        int buy = 0;
        int sale = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                if (flag == 1) {
                    buy = prices[i-1];
                    flag = -flag;
                }
            }
            if (prices[i] < prices[i-1]) {
                if (flag == -1) {
                    sale = prices[i-1];
                    res += sale - buy;
                    flag = -flag;
                }
            }
        }
        if (flag == -1) {
            res += prices[prices.length-1] - buy;
        }
        return res;
    }
    /*
    方法二：贪心，每天都买卖，若这天卖会亏，则让收益为0，否则加上这天收益
        public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
     */
}
