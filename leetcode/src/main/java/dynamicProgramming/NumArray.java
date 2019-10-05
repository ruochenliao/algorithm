package dynamicProgramming;


import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * 303. Range Sum Query - Immutable
 * Easy
 *
 * 555
 *
 * 852
 *
 * Favorite
 *
 * Share
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class NumArray {
    private int[] sum;
    public NumArray(int[] nums) {
        int m = nums.length;
        sum = new int[m+1];
        int localSum = 0;
        for(int i = 0; i < m; i++){
            localSum += nums[i];
            sum[i+1] = localSum;
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
}
