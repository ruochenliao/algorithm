package bfs;

import Utils.TreeNode;
import dfs.RecoverBinarySearchTree;

public class TestRecoverBinarySearchTree {
    public static void main(String[] args){
        RecoverBinarySearchTree searchTree = new RecoverBinarySearchTree();
//        TreeNode root = new TreeNode(20);
//        root.left = new TreeNode(15);
//        root.right = new TreeNode(50);
//        root.left.left = new TreeNode(10);
//        root.left.right = new TreeNode(18);
//        root.right.left = new TreeNode(40);
//        root.right.right = new TreeNode(60);
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(15);
        root.right = new TreeNode(50);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(18);
        root.right.left = new TreeNode(40);
        root.right.right = new TreeNode(60);
        searchTree.recoverTree(root);
        searchTree.recoverTreeInorder(root);
    }
}
