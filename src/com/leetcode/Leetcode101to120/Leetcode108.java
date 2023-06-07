package com.leetcode.Leetcode101to120;

import com.leetcode.tool.TreeNode;

import java.util.Arrays;

/*
    思路：递归，每次取最中间的作为根节点然后左子树使用左边部分
    的作为参数，右子树使用右边部分作为参数，若数组为空，则返回null
 */
public class Leetcode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        TreeNode node = new TreeNode();
        node.val = nums[(len-1)/2];
        node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, (len-1)/2));
        node.right = sortedArrayToBST(Arrays.copyOfRange(nums, (len-1)/2 + 1, len));
        return node;
    }
}
