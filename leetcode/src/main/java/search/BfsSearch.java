package search;

import Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BfsSearch {

    void bsfSearch(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            System.out.println(curNode.val);
            if(curNode.left != null){
                queue.offer(curNode.left);
            }
            if(curNode.right != null){
                queue.offer(curNode.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        BfsSearch search = new BfsSearch();
        search.bsfSearch(root);
    }

}
