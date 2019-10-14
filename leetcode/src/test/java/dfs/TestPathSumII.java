package dfs;

import Utils.TreeNode;
import Utils.TreeUtils;

import java.util.List;

public class TestPathSumII {
    public static void main(String[] args){
        PathSumII pathSumII = new PathSumII();
        TreeNode root = TreeUtils.createTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});
        int target = 22;
        List<List<Integer>> result = pathSumII.pathSum(root, target);
        for(List<Integer> list:result){
            for(Integer i:list){
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
