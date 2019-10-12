package dfs;

import Utils.TreeNode;
import Utils.TreeUtils;

public class TestRecoverBinarySearchTree {
    public static void main(String[] args){
        RecoverBinarySearchTree searchTree = new RecoverBinarySearchTree();
        TreeNode root = TreeUtils.createTree(new Integer[]{3,1,4,null,null,2});
        TreeUtils.printTree(root);
        searchTree.recoverTreeInorder(root);
        TreeUtils.printTree(root);
        TreeNode root1 = TreeUtils.createTree(new Integer[]{3,1,4,null,null,2});
        searchTree.recoverTreeRecursive(root1);
        TreeUtils.printTree(root1);

    }
}
