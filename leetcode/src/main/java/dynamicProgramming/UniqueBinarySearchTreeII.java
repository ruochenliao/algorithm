package dynamicProgramming;


import Utils.TreeNode;
import javafx.util.Pair;

import java.util.*;


public class UniqueBinarySearchTreeII {

    public List<TreeNode> generateTrees(int n) {
        if(n < 1){
            return new ArrayList<>();
        }
        Map<Pair, List<TreeNode>> map = new HashMap<>();
        return generateTree(1, n, map);
    }
    List<TreeNode> generateTree(int m,int n, Map<Pair, List<TreeNode>> map){
        if(m > n){
            return Collections.singletonList(null);
        }
        if(map.get(new Pair<>(m, n)) != null){
            return map.get(new Pair<>(m, n));
        }
        List<TreeNode> nodeList = new ArrayList<>();
        for(int i = m; i < n+1; i++){
            List<TreeNode> leftList = generateTree(m, i-1, map);
            List<TreeNode> rightList = generateTree(i+1, n, map);
            for(TreeNode left:leftList){
                for(TreeNode right: rightList){
                    TreeNode cur = new TreeNode(i);
                    cur.left = left;
                    cur.right = right;
                    nodeList.add(cur);
                }
            }
        }
        map.put(new Pair<>(m, n), nodeList);
        return nodeList;
    }
}

