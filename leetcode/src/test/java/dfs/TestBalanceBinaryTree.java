package dfs;

import Utils.TreeNode;
import Utils.TreeUtils;

public class TestBalanceBinaryTree {
    public static void main(String[] args){
        BalancedBinaryTree binaryTree = new BalancedBinaryTree();
        Integer[] nums = new Integer[]{1,2,2,3,3,null,null,4,4};
        TreeNode root = TreeUtils.createTree(nums);
        boolean result = binaryTree.isBalanced(root);
        System.out.println(result);
    }
}
