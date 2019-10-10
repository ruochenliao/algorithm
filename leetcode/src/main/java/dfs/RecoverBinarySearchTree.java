package dfs;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        List<TreeNode> twoNodes = getTwoNodes(root);
        swapTwoNodes(twoNodes);
    }

    private void swapTwoNodes(List<TreeNode> twoNodes) {

    }

    LinkedList<TreeNode> queue = new LinkedList<>();
    LinkedList<TreeNode> lower = new LinkedList<>();
    LinkedList<TreeNode> upper = new LinkedList<>();
    private List<TreeNode> getTwoNodes(TreeNode root){

        List<TreeNode> result = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            TreeNode lowerNode = lower.poll();
            TreeNode upperNode = upper.poll();
            if(lowerNode != null && lowerNode.val >= curNode.val){
                result.add(curNode);
            }
            if(upperNode != null && upperNode.val <= curNode.val){
                result.add(curNode);
            }
            if(curNode.left != null){
                inserNode(curNode.left, lowerNode, curNode);
            }
            if(curNode.right != null){
                inserNode(curNode.right, curNode, upperNode);
            }
        }
        return result;

    }

    private void inserNode(TreeNode curNode, TreeNode lowerNode, TreeNode upperNode){
        queue.add(curNode);
        lower.add(lowerNode);
        upper.add(upperNode);
    }


    public void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    public void recoverTreeInorder(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque();
        TreeNode x = null, y = null, pred = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) x = pred;
                else break;
            }
            pred = root;
            root = root.right;
        }

        swap(x, y);
    }
}
