package com.leetcode.Leetcode181to200;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode189 {
    /*方法一
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i <= n-k) {
                list.add(nums[i]);
            }
            int tem = (i-k+n) % n;
            if (tem <= list.size()) {
                nums[i] = nums[tem];
            } else {
                nums[i] = list.get(tem);
            }
        }
    }
     */
    //方法二：
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) {
            return;
        }
        int count = 0;
        int i = 0, start = 0;
        int last = nums[i];
        while (count < n) {
            int next = (i+k) % n;
            int tem = nums[next];
            nums[next] = last;
            last = tem;
            count++;
            i = next;
            if (start == i) {
                i++;
                start = i;
                last = nums[i];
            }
        }
    }
}
