package com.leetcode.Leetcode161to180;

import java.util.Arrays;

/*
    思路：首先将数组全部变为字符串，然后进行排序，排序规则
    为组成的数字最大，如a，b，若ab>ba，则a排在b前面，排序
    通过比较器完成，使用Array.sort的比较器制定规则进行排序
    最后去除前导0，然后返回字符串
 */
public class Leetcode179 {
    public String largestNumber(int[] nums) {
        StringBuffer sb = new StringBuffer();
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(ss, (a, b) -> {
            String stra = a + b, strb = b + a;
            return strb.compareTo(stra);
        });
        for (int i = 0; i < n; i++) {
            sb.append(ss[i]);
        }
        int k = 0;
        while (k < n-1 && ss[k].equals("0")) {
            k++;
        }
        return sb.substring(k);
    }
}
