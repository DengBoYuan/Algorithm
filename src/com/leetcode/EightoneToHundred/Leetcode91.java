package com.leetcode.EightoneToHundred;

/*
    思路：动态规划，数组dp[i]存储s前i个字符的解码方式
    当第i个字符不为0时，第i位可以单独解码，所以dp[i]至少
    等于dp[i-1]种，考虑第i-1和第i位组成的二位数小于26时，
    （即最后两位可以解码）则dp[i]又可以加上dp[i-2]种，而
    每次i只与i-1和i-2有关，所以用a，b，res三个数代表它们
 */
public class Leetcode91 {
    public int numDecodings(String s) {
        int a = 0, b = 1;
        int res = 0;
        for (int i = 1; i <= s.length(); i++) {
            res = 0;
            if (s.charAt(i-1) != '0') {
                res += b;
            }
            if (i > 1 && s.charAt(i-2) != '0' && ((s.charAt(i-2) - '0') * 10 + s.charAt(i-1) - '0') <= 26) {
                res += a;
            }
            a = b;
            b = res;
        }
        return res;
    }
}
