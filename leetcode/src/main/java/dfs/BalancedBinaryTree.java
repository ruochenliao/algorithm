package dfs;

import Utils.TreeNode;

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
