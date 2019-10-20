package dfs;

import Utils.TreeNode;
import Utils.TreeUtils;

import java.util.List;

public class TestBinaryTreePath {
    public static void main(String[] args){
        BinaryTreePath path = new BinaryTreePath();
        TreeNode root = TreeUtils.createTree(new Integer[]{37,-34,-48,null,-100,-100,48});
        TreeUtils.printTree(root);
        List<String> result = path.binaryTreePaths(root);
        for(String e:result){
            System.out.print(e+", ");
        }
        System.out.println();
        List<String> result2 = path.binaryTreePathsWithoutStringBuilder(root);
        for(String e:result2){
            System.out.print(e+", ");
        }
    }
}
