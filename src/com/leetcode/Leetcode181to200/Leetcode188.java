package com.leetcode.Leetcode181to200;

import java.util.Arrays;

/*
    思路：动态规划，buy（i，j）存储第i天是手上已经买了一笔，并且交易了j笔的最大利润
    sell（i，j）存储第i天时手上没有，即刚卖了一笔，并且交易了j笔的最大利润，易得：
    buy[i][j]=max{buy[i−1][j],sell[i−1][j]−price[i]}
    sell[i][j]=max{sell[i−1][j],buy[i−1][j−1]+price[i]}
    第0天肯定没有利润，所以设置很小的数代表不合法，最后返回sell中最大利润，因为手上没有
    买的时候利润肯定最大的
 */
public class Leetcode188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        int[][] buy = new int[n][k + 1];
        int[][] sell = new int[n][k + 1];

        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; ++i) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }

        return Arrays.stream(sell[n - 1]).max().getAsInt();
    }
}
