package com.leetcode.Leetcode21to40;

public class Leetcode29 {
//    public int divide(int dividend, int divisor) {
//        if (dividend == Integer.MIN_VALUE) {
//            if (divisor == 1) {
//                return Integer.MIN_VALUE;
//            }
//            if (divisor == -1) {
//                return Integer.MAX_VALUE;
//            }
//        }
//        if (divisor == Integer.MIN_VALUE) {
//            if (dividend == Integer.MIN_VALUE) {
//                return 1;
//            } else {
//                return 0;
//            }
//        }
//        if (dividend == 0) {
//            return 0;
//        }
//        boolean flag = false;
//        int mid = 0;
//        int dend = dividend, sor = divisor;
//        if (dividend > 0) {
//            dend = -dividend;
//            flag = !flag;
//        }
//        if (divisor > 0) {
//            sor = -divisor;
//            flag = !flag;
//        }
//        int left = 1, right = Integer.MAX_VALUE, ans = 0;
//        while (left <= right) {
//            mid =left + ((right - left) >> 1);
//            if (quickAdd(dend, sor, mid)) {
//                ans = mid;
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        return flag ? -ans : ans;
//    }

//    public boolean quickAdd(int a, int b, int c) {
//        int res = 0;
//        while (c > 0) {
//            if ((c & 1) == 1) {
//                res += b;
//            }
//            b += b;
//            c >>= 1;
//        }
//        if (res < a) {
//            return false;
//        } else {
//            return true;
//        }
//    }
public int quickAdd(int b, int c) {
    int res = 0;
    while (c > 0) {
        if ((c & 1) == 1) {
            res += b;
        }
        b += b;
        c >>= 1;
    }
    return res;
}
}
