package dynamicProgramming;


import Utils.TreeNode;
import javafx.util.Pair;

import java.util.*;

/**
 * 95. Unique Binary Search Trees II
 * Medium
 *
 * 1467
 *
 * 124
 *
 * Favorite
 *
 * Share
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class UniqueBinarySearchTreeII {
    /**
     * recursive
     * leftList = generateTree(m, i-1);
     * rightList = generateTree(i+1, n);
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if(n < 1){
            return new ArrayList<>();
        }
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        return generateTree(1, n);
    }
    List<TreeNode> generateTree(int m,int n){
        if(m > n){
            return Collections.singletonList(null);
        }
        List<TreeNode> nodeList = new ArrayList<>();
        for(int i = m; i < n+1; i++){
            List<TreeNode> leftList = generateTree(m, i-1);
            List<TreeNode> rightList = generateTree(i+1, n);
            for(TreeNode left:leftList){
                for(TreeNode right: rightList){
                    TreeNode cur = new TreeNode(i);
                    cur.left = left;
                    cur.right = right;
                    nodeList.add(cur);
                }
            }
        }
        return nodeList;
    }

    /**
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTreesDp(int n) {
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

