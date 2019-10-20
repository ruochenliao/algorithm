package dfs;

import Utils.TreeNode;
import Utils.TreeUtils;

public class TestBinaryTreeMaximumPathSum {
    public static void main(String[] args){
        BinaryTreeMaximumPathSum pathSum = new BinaryTreeMaximumPathSum();
        TreeNode root = TreeUtils.createTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1});
        TreeUtils.printTree(root);
        int maxSum = pathSum.maxPathSum(root);
        System.out.println(maxSum);
    }
}