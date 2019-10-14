package dfs;

import Utils.TreeNode;

public class FlattenBtToLinkedList {
    TreeNode copy;
    public void flatten1(TreeNode root) {
        copy = new TreeNode(0);
        TreeNode dummy = copy;
        flatten(root, dummy);
        root = dummy.right;
    }

    private void flatten(TreeNode root, TreeNode dummy) {
        if(root == null){
            return;
        }
        copy.right = new TreeNode(root.val);
        copy = copy.right;
        flatten(root.left, dummy);
        flatten(root.right, dummy);
    }

    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
