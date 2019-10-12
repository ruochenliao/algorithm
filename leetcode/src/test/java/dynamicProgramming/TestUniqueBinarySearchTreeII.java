package dynamicProgramming;

import Utils.TreeNode;
import Utils.TreeUtils;

import java.util.List;

public class TestUniqueBinarySearchTreeII {
    public static void main(String[] args){
        UniqueBinarySearchTreeII searchTreeII = new UniqueBinarySearchTreeII();
        List<TreeNode> list = searchTreeII.generateTrees(3);
        for(TreeNode treeNode:list){
            TreeUtils.printTree(treeNode);
        }
    }
}
