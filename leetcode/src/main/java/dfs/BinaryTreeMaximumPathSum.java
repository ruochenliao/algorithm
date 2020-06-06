package dfs;

import Utils.TreeNode;

/**
 * 124. Binary Tree Maximum Path Sum
 * Hard
 *
 * 2125
 *
 * 164
 *
 * Favorite
 *
 * Share
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 */
public class BinaryTreeMaximumPathSum {
    int maxPathSum(TreeNode root){
        maxPathSumRecursive(root);
        return globalSum;
    }

    int globalSum = Integer.MIN_VALUE;
    public int maxPathSumRecursive(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxPathSumRecursive(root.left);
        int right = maxPathSumRecursive(root.right);
        int localMax = Math.max(right + root.val, left + root.val);
        localMax = Math.max(localMax, root.val);
        int result = localMax;
        int linkedSum = left + right + root.val;
        localMax = Math.max(linkedSum, localMax);
        globalSum = Math.max(globalSum, localMax);
        return result;
    }
}
