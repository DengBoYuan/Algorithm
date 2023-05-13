package com.leetcode.FourtyoneToSixty;

/*
    思路：n=1，直接返回“1”；首先创建两个StringBuffer对象，一个
        存储初始字符串（升序）sb，另一个存储结果res；从结果第一个
        字符开始，总共有n！种排列，当前寻找的字符有n-i种情况，每
        种又有n-1-i！种，所以当前字符为sb中第k/n-i-1!个字符，然
        后将这个字符加入res中，并删去sb中这个字符（为了保证剩余字符
        的顺序），然后继续寻找下一个字符，当sb中只剩一个字符时，直接
        将这个剩余的字符加入res，然后返回
 */
public class Leetcode60 {
    public String getPermutation(int n, int k) {
        StringBuffer sb = new StringBuffer();
        StringBuffer res = new StringBuffer();
        int sum = 1;
        if (n == 1) {
            return "1";
        }
        for (int i = 1; i < n; i++) {
            sum *= i;
        }
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        k--;
        for (int i = 0; i < n - 1; i++) {
            int index = k / sum;
            res.append(sb.charAt(index));
            k -= (index * sum);
            sb.delete(index, index+1);
            sum /= (n-1-i);
            if (sb.length() == 1) {
                res.append(sb.charAt(0));
                break;
            }
        }
        return res.toString();
    }
}
