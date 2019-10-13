package dfs;

import Utils.TreeNode;
import Utils.TreeUtils;

public class TestConstructBinaryTreeFromPostOrder {
    public static void main(String[] args){
        ConstructBinaryTreeFromPostOrder postOrder = new ConstructBinaryTreeFromPostOrder();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = postOrder.buildTree(inorder, postorder);
        TreeUtils.printTree(root);
    }
}
