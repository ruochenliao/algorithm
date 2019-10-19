package dfs;

import Utils.TreeNode;
import Utils.TreeUtils;
import apple.laf.JRSUIUtils;

public class TestInorderSuccessorInBST {
    public static void main(String[] args){
        InorderSuccessorInBST inBST = new InorderSuccessorInBST();
        TreeNode root = TreeUtils.createTree(new Integer[]{5,3,6,1,4,null,null,2});
        TreeUtils.printTree(root);
        TreeNode successor = inBST.inorderSuccessor(root, root.left.right);
        System.out.println(successor.val);
        TreeNode successor1 = inBST.inorderSuccessorIterative(root, root.left.right);
        System.out.println(successor1.val);
    }
}
