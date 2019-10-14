package dfs;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSumRecursive(root, sum, result, new ArrayList<>());
        return result;
    }
    private void pathSumRecursive(TreeNode root, int sum, List<List<Integer>> result, List<Integer> curList){
        if(root == null){
            return;
        }
        sum = sum - root.val;
        curList.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == 0){
                List<Integer> list = new ArrayList<>(curList);
                result.add(list);
            }
        }
        pathSumRecursive(root.left, sum, result, curList);
        pathSumRecursive(root.right, sum, result, curList);
        curList.remove(curList.size() - 1);
    }
}
