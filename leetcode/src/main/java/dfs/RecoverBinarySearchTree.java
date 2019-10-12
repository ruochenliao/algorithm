package dfs;

import Utils.TreeNode;

import java.util.*;

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



    public void recoverTreeInorder(TreeNode root) {
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode x = null;
        TreeNode y = null;
        boolean isVisited = false;
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            if(prev!= null && prev.val >= cur.val){
                if(!isVisited){
                    // 第一次进入
                    x = prev;
                    y = cur;
                    isVisited = true;
                }
                else{
                    y = cur;
                }
            }
            prev = cur;
            root = cur.right;
        }
        swap(x, y);
    }

    private void swap(TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }




    public void recoverTreeRecursive(TreeNode root){
        TreeNode[] twoNodes = new TreeNode[2];
        recoverTreeRecursive(root, twoNodes);
        if(twoNodes[0] == null || twoNodes[1] == null){
            return;
        }
        swap(twoNodes);
    }
    private TreeNode prev = null;
    public void recoverTreeRecursive(TreeNode root, TreeNode[] twoNodes){
        if(root == null){
            return;
        }
        recoverTreeRecursive(root.left, twoNodes);
        if(prev != null && prev.val >= root.val){
            if(twoNodes[0] == null){
                twoNodes[0] = prev;
                twoNodes[1] = root;
            }
            else{
                twoNodes[1] = root;
            }
        }
        prev = root;
        recoverTreeRecursive(root.right, twoNodes);
    }
    private void swap(TreeNode[] twoNodes) {
        int tmp = twoNodes[0].val;
        twoNodes[0].val = twoNodes[1].val;
        twoNodes[1].val = tmp;
    }
}
