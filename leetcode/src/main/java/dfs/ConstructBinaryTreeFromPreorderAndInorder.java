package dfs;

import Utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorder {

    Map<Integer, Integer> map = new HashMap<>();
    int preorderIndex = 0;

    /**
     * preOrder recursive build binary tree
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildBinaryTree(int[] preorder, int[] inorder){
        for(int i = 0; i < inorder.length; i++){
            this.map.put(inorder[i], i);
        }
        return buildBinaryTree(preorder, 0, inorder.length - 1);
    }

    /**
     *
     * @param preorder
     * @param inorderLeft 用来记录 inorder 左边界
     * @param inorderRight 用来记录 inorder 右边界
     * @return
     */
    private TreeNode buildBinaryTree(int[] preorder, int inorderLeft, int inorderRight){
        if(inorderLeft > inorderRight){
            return null;
        }
        int curVal = preorder[preorderIndex];
        TreeNode root = new TreeNode(curVal);
        int inorderIndex = map.get(curVal);
        root.left = buildBinaryTree(preorder, inorderLeft, inorderIndex-1);
        root.right = buildBinaryTree(preorder, inorderIndex + 1, inorderRight);
        return root;
    }

}
