package com.leetcode.Leetcode101to120;

import com.leetcode.tool.TreeNode;

import java.util.Arrays;


/*
    思路：同105
 */
public class Leetcode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len == 0) {
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = postorder[len-1];
        for (int i = 0; i < len; i++) {
            if (inorder[i] == root.val) {
                root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i) );
                root.right = buildTree(Arrays.copyOfRange(inorder, i+1, len), Arrays.copyOfRange(postorder, i, len-1));
                break;
            }
        }
        return root;
    }
}
