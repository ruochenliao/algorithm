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
     * numTreesRecursive(m, n) 计算出从 m 到 n 能输出的 bst 的个数
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
     * 因为 (1,2,3) 和 (4,5,6) 两组生成的 bst 数都是相同的
     * 所以令cnt[n]: 从 1 到 n 组合出 cnt[n] bsf
     *
     *
     * recursive dp
     * @param n
     * @return
     */
    public int numTreesDp(int n) {
        return numTreesRecursive(n, new Integer[n+1]);
    }
    public int numTreesRecursive(int n, Integer[] cnt) {
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        if(cnt[n] != null){
            return cnt[n];
        }
        int temp = 0;
        for(int i = 1; i < n+1; i++){
            int left = numTreesRecursive(i-1, cnt);
            int right = numTreesRecursive(n - i, cnt);
            temp += left * right;
        }
        cnt[n] = temp;
        return temp;
    }
}
