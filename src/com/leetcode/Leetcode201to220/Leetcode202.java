package com.leetcode.Leetcode201to220;

/*
    思路：快慢指针，使用getNext函数模拟计算n的下一个数，
    初始fast，slow都是n，每次fast向后计算两次，slow一次
    当fast = slow时，判断是否为1，是则true，否则为false
 */
public class Leetcode202 {
    public boolean isHappy(int n) {
        if (getNext(n) == 1) {
            return true;
        }
        int fast = n, slow = n;
        do {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        } while (fast != slow);
        if (fast == 1) {
            return true;
        } else {
            return false;
        }
    }
    public int getNext(int n) {
        int res = 0;
        while (n > 0) {
            int tem = n % 10;
            res += tem * tem;
            n /= 10;
        }
        return res;
    }
}
