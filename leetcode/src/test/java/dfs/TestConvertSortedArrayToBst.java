package dfs;

import Utils.TreeNode;
import Utils.TreeUtils;

public class TestConvertSortedArrayToBst {
    public static void main(String[] args){
        ConvertSortedArrayToBst bst = new ConvertSortedArrayToBst();
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = bst.sortedArrayToBST(nums);
        TreeUtils.printTree(root);
    }
}
