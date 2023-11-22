package com.leetcode.Leetcode201to220;

import java.util.*;

/*
    思路：同207，只是每次深度优先搜索到底，开始回溯之后，
    每次回溯将当前课程号存入顺序表的最后
 */
public class Leetcode210 {

    List<List<Integer>> list;
    int[] visited;
    int[] res;
    int index;
    boolean valid = true;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res = new int[numCourses];
        visited = new int[numCourses];
        index = numCourses - 1;
        if (numCourses == 1) {
            res[0] = 0;
            return res;
        }
        list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            list.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
                if (!valid) {
                    res = new int[0];
                }
            }
        }
        return res;
    }

    public void dfs(int i) {
        visited[i] = 1;
        for (int x : list.get(i)) {
            if (visited[x] == 0) {
                dfs(x);
                if (!valid) {
                    return;
                }
            } else if (visited[x] == 1) {
                valid = false;
                return;
            }
        }
        visited[i] = 2;
        res[index] = i;
        index--;
    }
}
