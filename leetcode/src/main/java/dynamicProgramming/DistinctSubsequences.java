package dynamicProgramming;

/**
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * Example 1:
 *
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 * Explanation:
 *
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * Example 2:
 *
 * Input: S = "babgbag", T = "bag"
 * Output: 5
 * Explanation:
 *
 * As shown below, there are 5 ways you can generate "bag" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if(s == null || t == null){
            return 0;
        }
        Integer[][] dp = new Integer[s.length()+1][t.length()+1];
        return numDistinctRecursive(s, t,0, 0, dp);
    }

    /**
     * cnt = numDistinctRecursive(s,t, indexS, indexT, matchCnt, dp)
     * 代表了从 indexS 到 s.length() 有 cnt 种删除方案
     *
     * @param s
     * @param t
     * @param indexS
     * @param indexT
     * @param dp
     * @return
     */
    public int numDistinctRecursive(String s, String t, int indexS, int indexT, Integer[][] dp){
        if(indexS > s.length() || indexT > t.length()){
            return 0;
        }
        if(indexT == t.length()){
            return 1;
        }
        if(dp[indexS][indexT] != null){
            return dp[indexS][indexT];
        }
        int cnt = 0;
        if(indexT < t.length() && indexS < s.length() && s.charAt(indexS) == t.charAt(indexT)){
            cnt += numDistinctRecursive(s, t, indexS + 1, indexT + 1, dp);
        }
        cnt += numDistinctRecursive(s, t, indexS + 1, indexT, dp);
        dp[indexS][indexT] = cnt;
        return cnt;
    }
}
