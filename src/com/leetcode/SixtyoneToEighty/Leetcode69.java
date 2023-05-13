package com.leetcode.SixtyoneToEighty;

/*
    思路：二分查找
 */
public class Leetcode69 {
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        int left = 0, right = x/2+1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid * mid == x) {
                return mid;
            } else if ((long)mid * (long)mid < (long)x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left-1;
    }
}
