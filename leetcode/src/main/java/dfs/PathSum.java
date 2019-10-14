package dfs;

import Utils.TreeNode;

/**
 * 112. Path Sum
 * Easy
 *
 * 1173
 *
 * 375
 *
 * Favorite
 *
 * Share
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
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
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, 0, sum);
    }
    private boolean hasPathSum(TreeNode root, int sum, int target){
        if(root == null){
            return false;
        }
        sum = sum + root.val;
        if(root.left == null && root.right == null){
            return sum == target;
        }
        boolean isLeftHas = hasPathSum(root.left, sum, target);
        boolean isRightHas = hasPathSum(root.right, sum, target);
        return isLeftHas || isRightHas;
    }
}
