package com.leetcode.Leetcode81to100;

public class Leetcode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = m-1, k = n-1;
        for (int i = m+n-1; i >= 0; i--) {
            if (k < 0 || (j >= 0 && nums1[j] >= nums2[k])) {
                nums1[i] = nums1[j];
                j--;
            } else {
                nums1[i] = nums2[k];
                k--;
            }
        }
    }
}
