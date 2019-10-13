package dfs;

import Utils.TreeNode;
import Utils.TreeUtils;

public class TestValidateBinarySearchTree {
    public static void main(String[] args){
        TreeNode root = TreeUtils.createTree(new Integer[]{1,2,3,4,5});
        TreeUtils.printTree(root);
        ValidateBinarySearchTree searchTree = new ValidateBinarySearchTree();
        boolean result = searchTree.isValidBST(root);


        System.out.println(result);
        boolean result2 = searchTree.isValidBSTIterative(root);
        System.out.println(result2);
        boolean result3 = searchTree.isValidBSTIterativeBfs(root);
        System.out.println(result3);
    }
}
