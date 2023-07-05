package com.leetcode.Leetcode121to140;

import java.util.*;

/*
    思路：创建一个哈希表，记录每个单词的id，然后创建一个集合
    存储与每个单词相差一个字母的单词id，集合中的索引代表单词
    的id，单词集中的每个单词都创建虚拟节点，就是将单词的每个
    字母替换成*，代表任意字母，表示与该单词相差一个字母，并且
    也给这些虚拟节点一个id，然后创建一个数组存储从开始单词到
    当前单词的最短长度，初始赋值MAX，然后从开始单词起，进行
    bfs，若当前访问的单词为结尾单词，则返回数组中的值的一半
    否则，将该id数组中每个值置为+1，并且将改变值的id压入队列
    若为max说明没出现过，需要赋值，否则跳过
 */
class Leetcode127 {
    Map<String, Integer> wordId = new HashMap<String, Integer>();
    List<List<Integer>> edge = new ArrayList<List<Integer>>();
    int nodeNum = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        int[] dis = new int[nodeNum];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        dis[beginId] = 0;

        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(beginId);
        while (!que.isEmpty()) {
            int x = que.poll();
            if (x == endId) {
                return dis[endId] / 2 + 1;
            }
            for (int it : edge.get(x)) {
                if (dis[it] == Integer.MAX_VALUE) {
                    dis[it] = dis[x] + 1;
                    que.offer(it);
                }
            }
        }
        return 0;
    }

    public void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] array = word.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; ++i) {
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = tmp;
        }
    }

    public void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<Integer>());
        }
    }
}
