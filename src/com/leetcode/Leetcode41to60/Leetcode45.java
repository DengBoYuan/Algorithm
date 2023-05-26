package com.leetcode.Leetcode41to60;

/*
    思路：贪心算法：
         方法一：从最后一个位置i开始，然后从头遍历找出第一个能到当前位置i的
                数（即最远能到当前位置的数），然后将i更新为找出的
                数，每更新一次加一次跳跃结果，直到更新到i=1，返回次数次数
         方法二：从第一个位置i开始，记录当前能到最远位置maxFar，上一次跳跃
                到达的位置end（初始为0），当i=end时，更新end=maxFar，跳跃次数加一
                当i到达倒数第二个位置（即length-2）时，结束返回次数
 */

public class Leetcode45 {
    public int jump(int[] nums) {
        /*
        方法一：从后往前：
        if (nums.length == 1) {
            return 0;
        }
        int res = 0;
        int i = nums.length - 1;
        while (i > 0) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    i = j;
                    res++;
                    break;
                }
            }
        }
        return res;
         */
        //方法二：从前往后
        if (nums.length == 1) {
            return 0;
        }
        int res = 0;
        int end = 0;
        int maxFar = 0;
        for (int i = 0; i < nums.length; i++) {
            maxFar = Math.max(maxFar, i + nums[i]);
            if (end == i) {
                res++;
                end = maxFar;
            }
        }
        return res;
    }
}
