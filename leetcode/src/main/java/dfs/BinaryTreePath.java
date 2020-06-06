package dfs;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths
Easy

1571

94

Add to List

Share
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> globalList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        binaryTreePathsWithStringBuilder(root, stringBuilder, globalList);

        return globalList;
    }
    private void binaryTreePathsWithStringBuilder(TreeNode root, StringBuilder strBuilder, List<String> globalList) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            globalList.add(strBuilder.toString() + root.val);
            return;
        }
        strBuilder.append(root.val + "->");
        binaryTreePathsWithStringBuilder(root.left, strBuilder, globalList);
        binaryTreePathsWithStringBuilder(root.right, strBuilder, globalList);
        int sizeOfVal = (String.valueOf(root.val)).length();
        strBuilder.delete(strBuilder.length() - 2 - sizeOfVal, strBuilder.length());
    }

    public List<String> binaryTreePathsWithoutStringBuilder(TreeNode root) {
        List<String> result = new ArrayList<>();
        binaryTreePathsWithoutStringBuilder(root, result, "");
        return result;
    }
    private void binaryTreePathsWithoutStringBuilder(TreeNode root, List<String> result, String path){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            result.add(path + root.val);
            return;
        }
        binaryTreePathsWithoutStringBuilder(root.left, result, path + root.val + "->");
        binaryTreePathsWithoutStringBuilder(root.right, result, path + root.val + "->");
    }

}