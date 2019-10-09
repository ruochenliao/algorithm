package dfs;

import Utils.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

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
    /**
     * recursive
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root){
        return isValidBST(root, null, null);
    }
    public boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        if(root == null){
            return true;
        }
        if(lower != null && root.val <= lower){
            return false;
        }
        if(upper != null && root.val >= upper){
            return false;
        }
        if(!isValidBST(root.left, lower, root.val)){
            return false;
        }
        if(!isValidBST(root.right, root.val, upper)){
            return false;
        }
        return true;
    }

    /**
     * iterative bfs
     * @param treeNode
     * @return
     */
    private static LinkedList<TreeNode> curList = new LinkedList<>();
    private static LinkedList<Integer> lowerList = new LinkedList<>();
    private static LinkedList<Integer> upperList = new LinkedList<>();
    public boolean isValidBSTIterative(TreeNode treeNode){
        insertNode(treeNode, null, null);
        while(!curList.isEmpty()){
            TreeNode cur = curList.remove();
            Integer lowerVal = lowerList.remove();
            Integer upperVal = upperList.remove();
            if(cur == null){
                continue;
            }
            if(lowerVal != null && cur.val <= lowerVal){
                return false;
            }
            if(upperVal != null && cur.val >= upperVal){
                return false;
            }
            insertNode(cur.left, lowerVal, cur.val);
            insertNode(cur.right, cur.val, upperVal);
        }
        return true;
    }

    private void insertNode(TreeNode treeNode, Integer lower, Integer upper) {
        curList.add(treeNode);
        lowerList.add(lower);
        upperList.add(upper);
    }

    /**
     * iterative dfs
     * @param treeNode
     * @return
     */
    LinkedList<TreeNode> curList1 = new LinkedList<>();
    LinkedList<Integer> lowerList1 = new LinkedList<>();
    LinkedList<Integer> upperList1 = new LinkedList<>();
    public boolean isValidBSTIterativeBfs(TreeNode treeNode){
        insertNode1(treeNode, null, null);
        while(!curList1.isEmpty()){
            TreeNode cur = curList1.poll();
            Integer lowerVal = lowerList1.poll();
            Integer upperVal = upperList1.poll();
            if(cur == null){
                continue;
            }
            if(lowerVal != null && cur.val <= lowerVal){
                return false;
            }
            if(upperVal != null && cur.val >= upperVal){
                return false;
            }
            System.out.println(cur.val);
            insertNode1(cur.left, lowerVal, cur.val);
            insertNode1(cur.right, cur.val, upperVal);
        }
        return true;
    }

    private void insertNode1(TreeNode treeNode, Integer lower, Integer upper) {
        curList1.add(treeNode);
        lowerList1.add(lower);
        upperList1.add(upper);
    }

    public boolean isValidBSTInOrder1(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            while(root.left != null){
                stack.push(root.left);
                root = root.left;
            }
            root
        }
    }








    /**
     * inOrder traverse
     * @param root
     * @return
     */
    public boolean isValidBSTInOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
