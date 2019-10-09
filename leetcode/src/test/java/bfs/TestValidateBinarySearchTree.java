package bfs;

import Utils.TreeNode;
import dfs.ValidateBinarySearchTree;

public class TestValidateBinarySearchTree {
    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(-30);
        treeNode.left = new TreeNode(-31);
        treeNode.right = new TreeNode(-22);
        treeNode.right.left = new TreeNode(-25);
        treeNode.right.right = new TreeNode(80);
        ValidateBinarySearchTree searchTree = new ValidateBinarySearchTree();
        boolean result = searchTree.isValidBST(treeNode);
        System.out.println(result);
        boolean result2 = searchTree.isValidBSTIterative(treeNode);
        System.out.println(result2);
        boolean result3 = searchTree.isValidBSTIterativeBfs(treeNode);
        System.out.println(result3);
    }
}
