package com.leetcode.Leetcode141to160;

import java.util.HashMap;
import java.util.Map;

public class Leetcode149 {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (res > n - i) {
                break;
            }
            Map<Float, Integer> map = new HashMap<>();
            int max = 0;
            for (int j = i+1; j < n; j++) {
                float rate = 0;
                int a = points[i][0] - points[j][0];
                int b = points[i][1] - points[j][1];
                if (a == 0) {
                    rate = Float.MAX_VALUE;
                } else if (b == 0) {
                    rate = 0;
                } else {
                    rate = (float) b / a;
                }
                map.put(rate, map.getOrDefault(rate, 0) + 1);
                max = Math.max(max, map.get(rate));
            }
            res = Math.max(res, max);
        }
        return res + 1;
    }
}
