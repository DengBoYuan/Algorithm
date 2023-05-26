package com.leetcode.Leetcode61to80;

/*
    思路：双指针，一个指结果的末尾，一个指当前位置
 */
public class Leetcode80 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int m = 0, n = 0, flag = 0;
        int pre = nums[0];
        while (n < len) {
            if (nums[n] == pre) {
                flag++;
            } else {
                flag = 1;
            }
            if (flag <= 2) {
                nums[m] = nums[n];
            }
            pre = nums[n];
            n++;
        }
        return m+1;
    }
}
