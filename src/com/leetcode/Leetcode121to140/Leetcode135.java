package com.leetcode.Leetcode121to140;

/*
    思路：相邻的孩子评分高分的糖更多，所以将这个规则拆分成
    左右两个(一个与左边孩子比，一个与右边孩子比)，左规则：当
    ratings[i] > ratings[i-1]时，candy[i] =
    candy[i-1]+1，否则candy[i] = 1；右规则同理，然后
    每个孩子取两个规则分的糖果数更大的那个规则，最后全部相加
 */
public class Leetcode135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int res = 0;
        int[] candy = new int[n];
        int right = 1;
        candy[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                candy[i] = candy[i-1] + 1;
            } else {
                candy[i] = 1;
            }
        }
        res += Math.max(right, candy[n-1]);
        for (int i = n-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                right += 1;
            } else {
                right = 1;
            }
            res += Math.max(right, candy[i]);
        }
        return res;
    }
}
