package com.leetcode.Leetcode121to140;

/*
    思路：若总油量大于等于总耗油量，则一定存在一个解（不知证明）
    所以首先从0开始遍历，记录到各个加油站时剩余的油量，遍历完
    之后（即饶了一圈）的剩余油量小于0，则无解，否则返回最低
    剩余油量的下一个加油站
 */
public class Leetcode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int rest = 0;
        int minRest = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < len; i++) {
            rest += gas[i] - cost[i];
            if (rest < minRest) {
                minRest = rest;
                minIndex = i;
            }
        }
        if (minRest >= 0) {
            return 1;
        }
        return rest < 0 ? -1 : (minIndex + 1) % len;
    }
}
