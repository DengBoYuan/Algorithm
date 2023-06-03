package com.leetcode.Leetcode101to120;

import com.leetcode.tool.TreeNode;

import java.util.Arrays;

/*
    思路：递归，前序的第一个是根节点，然后在中序中找出根节点所在位置，
    它前面的序列就是左子树的中序，后边的序列就是右子树的中序，然后在前
    序中根节点后面一段就是左子树的前序，剩下的就是右子树的前序，然后将
    这些作为参数进行递归
 */
public class Leetcode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len == 0) {
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = preorder[0];
        for (int i = 0; i < len; i++) {
            if (inorder[i] == root.val) {
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i+1), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i+1, len), Arrays.copyOfRange(inorder, i+1, len));
                break;
            }

        }
        return root;
    }
}
