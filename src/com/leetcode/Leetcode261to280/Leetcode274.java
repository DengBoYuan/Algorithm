package com.leetcode.Leetcode261to280;

public class Leetcode274 {
    //方法一：快排，排成逆序，从头遍历，出现第i个数小于i+1时，结束，返回i
//    public int hIndex(int[] citations) {
//        this.sort(citations, 0, citations.length-1);
//        for (int i = 0; i < citations.length; i++) {
//            if (citations[i] < i+1) {
//                return i;
//            }
//        }
//        return citations.length;
//    }
//    public void sort(int[] citations, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//        int i = left, j = right;
//        int temp = citations[left];
//        int flag= 0;
//        while (right > left) {
//            if (flag == 0) {
//                if (citations[right] > temp) {
//                    citations[left] = citations[right];
//                    left++;
//                    flag = 1;
//                } else {
//                    right--;
//                }
//            } else {
//                if (citations[left] < temp) {
//                    citations[right] = citations[left];
//                    right--;
//                    flag = 0;
//                } else {
//                    left++;
//                }
//            }
//        }
//        citations[left] = temp;
//        sort(citations, i, left-1);
//        sort(citations, left+1, j);
//    }
    /*
    方法二：使用数组count记录引用次数为i的数量，
    然后从后向前遍历，引用次数大于等于i的下标即为h指数
    */
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n+1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                count[n]++;
            } else {
                count[citations[i]]++;
            }
        }
        int pre = 0;
        for (int j = n; j >= 0; j--) {
            pre += count[j];
            if (pre >= j) {
                return j;
            }
        }
        return 0;
    }
}
