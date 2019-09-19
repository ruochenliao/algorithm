package dynamicProgramming;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * 96. Unique Binary Search Trees
 * Medium
 *
 * 2040
 *
 * 79
 *
 * Favorite
 *
 * Share
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class UniqueBinarySearchTree {
    /**
     * recursive
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if(n < 1){
            return 0;
        }
        return numTreesRecursive(1, n);
    }

    public int numTreesRecursive(int m, int n){
        if(m > n){
            return 1;
        }
        int cnt = 0;
        for(int i = m; i < n + 1; i++){
            int left = numTreesRecursive(m, i -1);
            int right = numTreesRecursive(i+1, n);
            cnt += left * right;
        }
        return cnt;
    }

    /**
     * iterative
     * @param n
     * @return
     */
    public int numTreesIterative(int n) {
        if(n < 1){
            return 0;
        }
        Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
        return numTreesIterative(1, n, map);
    }

    public int numTreesIterative(int m, int n, Map<Pair<Integer, Integer>, Integer> map){
        if(m > n){
            return 1;
        }
        if(map.get(new Pair<>(m, n)) != null){
            return map.get(new Pair<>(m, n));
        }
        int cnt = 0;
        for(int i = m; i < n + 1; i++){
            int left = numTreesIterative(m, i -1, map);
            int right = numTreesIterative(i+1, n, map);
            cnt += left * right;
        }
        map.put(new Pair<>(m,n), cnt);
        return cnt;
    }
}
