package com.leetcode.Leetcode121to140;

import com.leetcode.tool.GraphNode;

import java.util.*;

/*
    思路：广度优先搜索
 */
public class Leetcode133 {
    public GraphNode cloneGraph(GraphNode node) {
        Map<Integer, GraphNode> isCreate = new HashMap<>();
        Set<Integer> isFinish = new HashSet<>();
        Queue<GraphNode> queue1 = new LinkedList<>();
        Queue<GraphNode> queue2 = new LinkedList<>();
        GraphNode root = new GraphNode();
        root.val = node.val;
        isCreate.put(root.val, root);
        queue1.offer(node);
        queue2.offer(root);
        while (!queue1.isEmpty()) {
            GraphNode tem1 = queue1.poll();
            if (isFinish.contains(tem1.val)) {
                continue;
            }
            GraphNode tem2 = queue2.poll();
            List<GraphNode> list = tem1.neighbors;
            for (int i = 0; i < list.size(); i++) {
                if (isFinish.contains(list.get(i).val)) {
                    continue;
                }
                GraphNode cur;
                if (!isCreate.containsKey(list.get(i).val)) {
                    cur = new GraphNode();
                    cur.val = list.get(i).val;
                    tem2.neighbors.add(cur);
                    cur.neighbors.add(tem2);
                    isCreate.put(list.get(i).val, cur);
                } else {
                    cur = isCreate.get(list.get(i).val);
                    tem2.neighbors.add(cur);
                    cur.neighbors.add(tem2);
                }
                queue1.offer(list.get(i));
                queue2.offer(cur);
            }
            isFinish.add(tem1.val);
        }
        return root;
    }
}
