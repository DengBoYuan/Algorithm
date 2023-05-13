package com.leetcode.SixtyoneToEighty;

/*
    思路：双指针遍历，一个指0（头），一个指2（尾）
        将0与头指针交换，2与尾指针交换，若与2换
        的时候仍是2，则要继续交换
 */
public class Leetcode75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; ++i) {
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }
}
