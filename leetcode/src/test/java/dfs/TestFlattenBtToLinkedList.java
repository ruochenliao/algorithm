package dfs;

import Utils.TreeNode;
import Utils.TreeUtils;

public class TestFlattenBtToLinkedList {
    public static void main(String[] args){
        TreeNode root= TreeUtils.createTree(new Integer[]{1,2,3,4,5,6,7});
        FlattenBtToLinkedList flattenBtToLinkedList = new FlattenBtToLinkedList();
        TreeUtils.printTree(root);
        flattenBtToLinkedList.flatten(root);
        TreeUtils.printTree(root);
    }
}
