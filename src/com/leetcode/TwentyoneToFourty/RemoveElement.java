package com.leetcode.TwentyoneToFourty;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int res = nums.length;
        int head = 0, tail = nums.length - 1;
        while (head <= nums.length - 1) {
            if (nums[head] == val) {
                while (head < tail) {
                    if (nums[tail] != val) {
                        nums[head] = nums[tail];
                        break;
                    } else {
                        tail--;
                    }
                }
                head++;
                tail--;
                res--;
            } else {
                head++;
            }
        }
        return res;
    }
}
