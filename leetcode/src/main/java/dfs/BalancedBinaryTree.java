package dfs;

import Utils.TreeNode;

/**
 * 110. Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7

 Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return maxDiffDepth(root) != -1;
    }
    private int maxDiffDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHight = maxDiffDepth(root.left);
        int rightHeight = maxDiffDepth(root.right);
        if(leftHight == -1 || rightHeight == -1){
            return -1;
        }
        if(Math.abs(leftHight - rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHight, rightHeight) + 1;
    }
}
