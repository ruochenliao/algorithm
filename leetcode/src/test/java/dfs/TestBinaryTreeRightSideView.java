package dfs;

import Utils.TreeNode;
import Utils.TreeUtils;

import java.util.List;

public class TestBinaryTreeRightSideView {
    public static void main(String[] args){
        BinaryTreeRightSideView view = new BinaryTreeRightSideView();
        TreeNode root = TreeUtils.createTree(new Integer[]{1,2,3,null,5,null,4});
        List<Integer> result = view.rightSideView(root);
        for(Integer e:result){
            System.out.println(e);
        }
    }
}
