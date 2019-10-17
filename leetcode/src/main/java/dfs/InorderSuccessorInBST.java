package dfs;

import Utils.TreeNode;

public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p!= null && p.right != null){
            return findTheMinimum(p.right);
        }
        TreeNode parent = p.parent;
        while(parent != null && parent.right == p){
            p = parent;
            parent = parent.parent;
        }
        return parent;
    }

    private TreeNode findTheMinimum(TreeNode root) {
        if(root == null){
            return root;
        }
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}
