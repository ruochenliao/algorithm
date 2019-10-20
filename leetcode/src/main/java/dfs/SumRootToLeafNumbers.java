package dfs;

import Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 129. Sum Root to Leaf Numbers
 * Medium
 *
 * 838
 *
 * 29
 *
 * Favorite
 *
 * Share
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 *
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class SumRootToLeafNumbers {
    int globalSum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.remove();
                if(node.left == null && node.right == null){
                    globalSum += node.val;
                }
                if(node.left != null){
                    node.left.val = node.left.val + node.val * 10;
                    queue.offer(node.left);
                }
                if(node.right != null){
                    node.right.val = node.right.val + node.val * 10;
                    queue.offer(node.right);
                }
            }
        }
        return globalSum;
    }

    private int globalSumRecursive;
    public int sumNumbersRecursive(TreeNode root){
        sumNumbersRecursive(root, 0);
        return globalSumRecursive;
    }

    private void sumNumbersRecursive(TreeNode root, int upperSum) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            globalSumRecursive += 10 * upperSum + root.val;
            return;
        }
        int sum = upperSum * 10 + root.val;
        sumNumbersRecursive(root.left, sum);
        sumNumbersRecursive(root.right, sum);
    }
}
