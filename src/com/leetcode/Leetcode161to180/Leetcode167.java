package com.leetcode.Leetcode161to180;

public class Leetcode167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int len = numbers.length;
        int left = 0, right = len - 1;
        while (right > left) {
            if ((numbers[left] + numbers[right]) == target) {
                res[0] = left+1;
                res[1] = right+1;
                return res;
            } else if ((numbers[left] + numbers[right]) > target){
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}
