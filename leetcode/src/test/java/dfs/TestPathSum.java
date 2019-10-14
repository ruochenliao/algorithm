package dfs;

import Utils.TreeNode;
import Utils.TreeUtils;

public class TestPathSum {
    public static void main(String[] args){
        PathSum sum = new PathSum();
        Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root = TreeUtils.createTree(nums);
        boolean result = sum.hasPathSum(root, 22);
        System.out.println(result);
    }
}
