package com.leetcode.Leetcode161to180;

/*
    思路：投票算法，设置一个numb代表票数，设置res为
    当前投票的数字，当票数为0时（当前无投票的数字）就
    设置当前数字为投票数字，否则判断当前数字与投票数字
    是否相等，若相等则票数加一，不相等减一，最后的投票
    数字就是众数
 */
public class Leetcode169 {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int numb = 0;
        Integer res = null;
        for (int num : nums) {
            if (numb == 0) {
                res = num;
            }
            numb += (num == res) ? 1 : -1;
        }
        return res;
    }
}
