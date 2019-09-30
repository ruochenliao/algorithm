package dynamicProgramming;

/**
 * 132. Palindrome Partitioning II
 * Hard
 *
 * 707
 *
 * 25
 *
 * Favorite
 *
 * Share
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitionII {
    /**
     * isPalindrome[i][j] 判断 s[i~j] 是否是 palindrome
     * minCut[j] 判断 s[0~j] 最少需要分割 minCut[j] 刀
     * @param s
     * @return
     */
    public int minCut(String s) {
        int n = s.length();
        int[] minCut = new int[n];
        boolean[][] isPalindrome = new boolean[n][n];
        for(int i = 0; i < n; i++){
            int localMax = i;
            for(int j = 0; j <= i; j++){
                if(s.charAt(i) == s.charAt(j)
                        && (j+1 > i -1 || isPalindrome[j+1][i-1])){
                    isPalindrome[j][i] = true;
                    int prevCut = j == 0? 0:minCut[j-1] + 1;
                    localMax = Math.min(localMax, prevCut);
                }
            }
            minCut[i] = localMax;
        }
        return minCut[n-1];
    }
}
