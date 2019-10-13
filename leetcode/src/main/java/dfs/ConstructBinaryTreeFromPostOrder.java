package dfs;

import Utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPostOrder {
    private int curIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();

    /**
     * postOrder recursive construct the tree
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        curIndex = inorder.length - 1;
        return buildTree(postorder, 0, postorder.length -1 );
    }
    private TreeNode buildTree(int[] postorder, int inorderLeft, int inorderRight) {
        if(inorderLeft > inorderRight){
            return null;
        }
        int curVal  = postorder[curIndex];
        TreeNode root = new TreeNode(curVal);
        int inorderIndex = map.get(curVal);
        curIndex--;
        root.right = buildTree(postorder, inorderIndex+1, inorderRight);
        root.left = buildTree(postorder, inorderLeft, inorderIndex-1);
        return root;
    }
}
