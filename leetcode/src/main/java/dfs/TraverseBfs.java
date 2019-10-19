package dfs;

import Utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TraverseBfs {
    public void searchIterative(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                root = queue.remove();
                System.out.print(root.val + ",");
                if(root.left != null){
                    queue.add(root.left);
                }
                if(root.right != null){
                    queue.add(root.right);
                }
            }
        }
    }

    public void inorderIterative(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            while(root.left!= null){
                stack.push(root.left);
                root = root.left;
            }
            TreeNode node = stack.pop();
            System.out.print(node.val + ",");
            if(node.right!= null){
                stack.push(node.right);
                root = node.right;
            }
        }
    }

}
