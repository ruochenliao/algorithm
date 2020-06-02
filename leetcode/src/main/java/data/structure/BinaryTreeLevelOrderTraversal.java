package data.structure;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 102. Binary Tree Level Order Traversal
Medium

2711

65

Add to List

Share
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 *
 */

public class BinaryTreeLevelOrderTraversal {

    private void helper(List<List<Integer>> lists, TreeNode treeNode, int level) {
        if (treeNode == null) {
            return;
        }

        if (lists.size() == level) {
            lists.add(new ArrayList<>());
        }

        List<Integer> curLayer = lists.get(level);
        curLayer.add(treeNode.val);
        helper(lists, treeNode.left, level + 1);
        helper(lists, treeNode.right, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode treeNode) {
        List<List<Integer>> lists = new ArrayList<>();
        helper(lists, treeNode, 0);
        return  lists;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        BinaryTreeLevelOrderTraversal traversal = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> lists = traversal.levelOrder(treeNode);
        lists.forEach(list-> {
            list.forEach(item-> System.out.print(item + " "));
            System.out.println();
        });
    }
}
