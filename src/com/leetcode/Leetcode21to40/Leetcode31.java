package com.leetcode.Leetcode21to40;

public class Leetcode31 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return;
        }
        if (len == 2) {
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
            return;
        }
        int i = len - 1, flag = 0;
        while (i >= 1) {
            if (nums[i-1] < nums[i]) {
                int min = 0;
                for (int j = len - 1; j >= i; j--) {
                    if (nums[j] > nums[i-1]) {
                        min = nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1] = min;
                        break;
                    }
                }
                for (int k = 0; k <= (len - 1 - i) / 2; k++) {
                    int temp = nums[i+k];
                    nums[k] = nums[len-1-k];
                    nums[len-1-k] = temp;
                }
                return;
            }
            i--;
        }
        for (int m = 0; m <= (len-1) / 2; m++) {
            int tem = nums[m];
            nums[m] = nums[len-1-m];
            nums[len-1-m] = tem;
        }
        return;
    }
}
