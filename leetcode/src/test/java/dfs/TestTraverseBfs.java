package dfs;

import Utils.TreeNode;
import Utils.TreeUtils;

public class TestTraverseBfs {
    public static void main(String[] args){
        TraverseBst bfs = new TraverseBst();
        TreeNode root = TreeUtils.createTree(new Integer[]{5,3,10,2,4,7,20,1});
        TreeUtils.printTree(root);
        System.out.println("iterative search");
        bfs.searchIterative(root);
        System.out.println();
        System.out.println("inorder search");
        bfs.inorderIterative(root);
        System.out.println();
        System.out.println("preorder search");
        bfs.preorder(root);
    }
}
