package com.leetcode.Leetcode201to220;

import java.util.Arrays;

/*
    埃氏筛算法，若一个数为质数，则该数的倍数一定不是质数，
    所以创建一个数组用于存储数字是否是质数，下标代表数字，
    0代表非质数，1代表质数，初始令所有都是1，从2开始遍历
    若为1，则质数加1，并且将所有倍数改为0，然后继续遍历
 */
public class Leetcode204 {
    public int countPrimes(int n) {
        int res = 0;
        int[] list = new int[n];
        Arrays.fill(list, 1);
        for (int i = 2; i < n; i++) {
            if (list[i] == 1) {
                res++;
                int j = 2;
                while (i * j < n) {
                    list[i * j] = 0;
                    j++;
                }
            }
        }
        return res;
    }
}
