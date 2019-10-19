package dfs;

import Utils.TreeNode;

import java.util.Stack;

public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null){
            return null;
        }
        TreeNode leftNode = inorderSuccessor(root.left, p);
        if(leftNode != null){
            return leftNode;
        }
        if(p.val < root.val){
            return root;
        }
        TreeNode rightNode = inorderSuccessor(root.right, p);
        if(rightNode != null){
            return rightNode;
        }
        return null;
    }

    public TreeNode inorderSuccessorIterative(TreeNode root, TreeNode p){
        //child 在右子树
        if(p.right != null){
            p = p.right;
            while(p.left != null){
                p = p.left;
            }
            return p;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;
        while(!stack.isEmpty()){
            while(root.left!=null){
                stack.push(root.left);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if(p.equals(prev)){
                return node;
            }
            if(node.right != null){
                stack.push(node.right);
                root = node.right;
            }
            prev = node;
        }
        return null;
    }
}
