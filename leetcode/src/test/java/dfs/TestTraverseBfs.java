package dfs;

import Utils.TreeNode;
import Utils.TreeUtils;

public class TestTraverseBfs {
    public static void main(String[] args){
        TraverseBfs bfs = new TraverseBfs();
        TreeNode root = TreeUtils.createTree(new Integer[]{5,3,10,2,4,7,20,1});
        bfs.searchIterative(root);
        System.out.println();
        bfs.inorderIterative(root);
    }
}
