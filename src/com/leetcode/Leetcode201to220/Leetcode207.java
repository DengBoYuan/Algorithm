package com.leetcode.Leetcode201to220;

import java.util.ArrayList;
import java.util.List;


/*
    思路：深度优先搜索，使用一个数组表示课程的状态，下标为课程编号，0为未搜索，
    1为正在搜索，2为搜索完，再创建一个集合存放课程的后续课程，首先用prerequisites
    初始化集合，然后从0开始进行深度优先搜索，每次搜索前先将当前课程状态设为1，
    然后继续向后搜索，若搜索的状态为1，则说明成环了，直接返回false，2则什么
    都不做，0则正常dfs，搜索完后状态设为2
 */
public class Leetcode207 {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        visited = new int[numCourses];
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }
    public void dfs(int n) {
        visited[n] = 1;
        for (int x : edges.get(n)) {
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
        visited[n] = 2;
    }
}
