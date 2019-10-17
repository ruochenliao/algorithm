package dfs;

import Utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TraverseBfs {
    public void searchIterative(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                root = queue.remove();
                System.out.println(root.val);
                if(root.left != null){
                    queue.add(root.left);
                }
                if(root.right != null){
                    queue.add(root.left);
                }
            }
        }
    }

    public void preOrderSearchRecursive(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preOrderSearchRecursive(root.left);
        preOrderSearchRecursive(root.right);
    }
    public void preOrderSearchIterative(TreeNode root){
        List<TreeNode> list = new LinkedList<>();
    }
}
