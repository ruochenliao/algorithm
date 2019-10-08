package dfs;

import Utils.TreeNode;

/**
 * 98. Validate Binary Search Tree
 * Medium
 *
 * 2444
 *
 * 360
 *
 * Favorite
 *
 * Share
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left != null){
            boolean isLeftMatch = isValidBST(root.left);
            if(!isLeftMatch){
                return false;
            }
            if(root.left.val >= root.val){
                return false;
            }
        }
        if(root.right != null){
            boolean isRightMatch = isValidBST(root.right);
            if(!isRightMatch){
                return false;
            }
            if(root.val >= root.right.val){
                return false;
            }
        }
        return true;
    }

}
