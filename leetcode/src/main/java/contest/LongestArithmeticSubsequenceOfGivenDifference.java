package contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 5214. Longest Arithmetic Subsequence of Given Difference
 * User Accepted: 1097
 * User Tried: 1885
 * Total Accepted: 1103
 * Total Submissions: 3076
 * Difficulty: Medium
 * Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,3,4], difference = 1
 * Output: 4
 * Explanation: The longest arithmetic subsequence is [1,2,3,4].
 * Example 2:
 *
 * Input: arr = [1,3,5,7], difference = 1
 * Output: 1
 * Explanation: The longest arithmetic subsequence is any single element.
 * Example 3:
 *
 * Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * Output: 4
 * Explanation: The longest arithmetic subsequence is [7,5,3,1].
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 10^5
 * -10^4 <= arr[i], difference <= 10^4
 */
public class LongestArithmeticSubsequenceOfGivenDifference {
    /**
     * TLE: O(N^2)
     * @param arr
     * @param difference
     * @return
     */
    public int longestSubsequence(int[] arr, int difference) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        int m = arr.length;
        int[] dp = new int[m]; //dp[i] 0 到 i longest subsequence 数量
        int maxLength = 1;
        for(int i = 0; i < m; i++){
            int localMax = 1;
            for(int j = 0; j < i; j++){
                if(arr[i] - arr[j] == difference){
                    localMax = Math.max(localMax, dp[j] + 1);
                }
            }
            dp[i] = localMax;
            maxLength = Math.max(maxLength, localMax);
        }
        return maxLength;
    }

    public int longestSubsequenceHashMap(int[] arr, int difference){
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 1;
        for(int i = 0; i < arr.length; i++){
            int len = 1;
            if(map.get(arr[i] - difference) != null){
                len = map.get(arr[i] - difference) + 1;
            }
            map.put(arr[i], len);
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
