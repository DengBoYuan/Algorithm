package com.leetcode.core.oneToTwenty;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length + nums2.length) % 2 == 1) {
            return getKElement(nums1, nums2, (nums1.length + nums2.length) / 2 + 1);
        } else {
            int res1 = getKElement(nums1, nums2, (nums1.length + nums2.length) / 2);
            int res2 = getKElement(nums1, nums2, (nums1.length + nums2.length) / 2 + 1);
            return (res1 + res2) / 2.;
        }
    }

    public int getKElement(int[] nums1, int[] nums2, int k) {
        int point1 = 0, point2 = 0;
        while (k > 1) {
            if (point1 >= nums1.length) return nums2[point2 + k - 1];
            if (point2 >= nums2.length) return nums1[point1 + k - 1];

            int new_point1 = Math.min(point1 + k / 2 - 1, nums1.length - 1);
            int new_point2 = Math.min(point2 + k / 2 - 1, nums2.length - 1);
            System.out.printf("%d, %d, %d, %d, %d\n", point1, point2, new_point1, new_point2, k);
            if (nums1[new_point1] < nums2[new_point2]) {
                k -= new_point1 - point1 + 1;
                point1 = new_point1 + 1;
            } else {
                k -= new_point2 - point2 + 1;
                point2 = new_point2 + 1;
            }
        }

        if (point1 >= nums1.length) {
            return nums2[point2];
        }
        if (point2 >= nums2.length) {
            return nums1[point1];
        }
        return Math.min(nums1[point1], nums2[point2]);
    }
}
