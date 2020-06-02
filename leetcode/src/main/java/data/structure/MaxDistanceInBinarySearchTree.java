package data.structure;

import Utils.TreeNode;

/**
 * 在一棵二叉树中，最大的节点距离是多少
 *
 * 解法，
 * 过某个节点的最大距离是 = 过这个个节点的左右子树的深度 + 2
 * 那么，过每个节点的时候算左右子树深度就行了
 *
 * 把获取树的深度的题改一改就好了
 *
 */
public class MaxDistanceInBinarySearchTree {

    private static Integer maxDistance = -1;

    int maxDistanceOfTree(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = maxDistanceOfTree(root.left);
        int rightDepth = maxDistanceOfTree(root.right);
        maxDistance = Math.max(maxDistance, leftDepth + rightDepth + 2);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        MaxDistanceInBinarySearchTree searchTree = new MaxDistanceInBinarySearchTree();
        TreeNode root = buildTree();
        searchTree.maxDistanceOfTree(root);
        System.out.println(maxDistance);
    }

    private static TreeNode buildTree() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        return root;
    }
}
