package com.leetcode.Leetcode61to80;

/*
    思路：双指针，一个指结果的末尾，一个指当前位置
 */
public class Leetcode80 {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int count = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                count = 1;
                slow++;
                nums[slow] = nums[fast];
            } else if (count == 1) {
                count++;
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1;
    }
}
