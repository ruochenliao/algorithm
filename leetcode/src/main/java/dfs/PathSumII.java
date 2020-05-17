package dfs;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 113. Path Sum II
 * Medium
 *
 * 1537
 *
 * 56
 *
 * Add to List
 *
 * Share
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
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
