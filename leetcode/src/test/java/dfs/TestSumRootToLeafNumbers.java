package dfs;

import Utils.TreeNode;
import Utils.TreeUtils;

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
public class TestSumRootToLeafNumbers {
    public static void main(String[] args){
        SumRootToLeafNumbers numbers = new SumRootToLeafNumbers();
        TreeNode root = TreeUtils.createTree(new Integer[]{1,2,3});
        TreeUtils.printTree(root);
        int sum = numbers.sumNumbers(root);
        System.out.println(sum);
        TreeNode root2 = TreeUtils.createTree(new Integer[]{1,2,3});
        TreeUtils.printTree(root2);
        int sum2 = numbers.sumNumbersRecursive(root2);
        System.out.println(sum2);
    }
}
