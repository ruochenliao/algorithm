package dfs;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> globalList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        binaryTreePathsWithStringBuilder(root, stringBuilder, globalList);

        return globalList;
    }
    private void binaryTreePathsWithStringBuilder(TreeNode root, StringBuilder strBuilder, List<String> globalList) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            globalList.add(strBuilder.toString() + root.val);
            return;
        }
        strBuilder.append(root.val + "->");
        binaryTreePathsWithStringBuilder(root.left, strBuilder, globalList);
        binaryTreePathsWithStringBuilder(root.right, strBuilder, globalList);
        int sizeOfVal = (String.valueOf(root.val)).length();
        strBuilder.delete(strBuilder.length() - 2 - sizeOfVal, strBuilder.length());
    }

    public List<String> binaryTreePathsWithoutStringBuilder(TreeNode root) {
        List<String> result = new ArrayList<>();
        binaryTreePathsWithoutStringBuilder(root, result, "");
        return result;
    }
    private void binaryTreePathsWithoutStringBuilder(TreeNode root, List<String> result, String path){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            result.add(path + root.val);
            return;
        }
        binaryTreePathsWithoutStringBuilder(root.left, result, path + root.val + "->");
        binaryTreePathsWithoutStringBuilder(root.right, result, path + root.val + "->");
    }

}