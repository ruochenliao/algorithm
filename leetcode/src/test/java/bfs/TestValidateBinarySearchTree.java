package bfs;

import Utils.TreeNode;
import dfs.ValidateBinarySearchTree;

public class TestValidateBinarySearchTree {
    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        ValidateBinarySearchTree searchTree = new ValidateBinarySearchTree();
        boolean result = searchTree.isValidBST(treeNode);
        System.out.println(result);
    }
}
