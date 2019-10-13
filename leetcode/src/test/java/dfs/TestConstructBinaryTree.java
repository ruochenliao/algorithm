package dfs;

import Utils.TreeNode;
import Utils.TreeUtils;

public class TestConstructBinaryTree {
    public static void main(String[] args){
        ConstructBinaryTreeFromPreorderAndInorder inorder = new ConstructBinaryTreeFromPreorderAndInorder();
        int[] pre= {1,2};
        int[] in = {1,2};

        TreeNode root1 = inorder.buildBinaryTree(pre, in);
        TreeUtils.printTree(root1);
    }
}
