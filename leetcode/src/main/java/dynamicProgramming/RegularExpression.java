package dynamicProgramming;


/**
 * 10. Regular Expression Matching
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 * <p>
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * <p>
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 * <p>
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 * <p>
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 * Example 5:
 * <p>
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */
public class RegularExpression {
    /**
     * 递归法
     * @param text
     * @param pattern
     * @return
     */
    public boolean isMatchRecursion(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean firstMatch = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (firstMatch && isMatchRecursion(text.substring(1), pattern))
                    || isMatchRecursion(text, pattern.substring(2));
        } else {
            return firstMatch && isMatchRecursion(text.substring(1), pattern.substring(1));
        }
    }

    /**
     * 自顶向下
     *
     * @param text
     * @param pattern
     * @return
     */
    public boolean isMatchRecursive(String text, String pattern) {
        Boolean[][] dp = new Boolean[text.length() + 1][pattern.length() + 1];
        return isMatchRecursive(0, 0, text, pattern, dp);
    }

    public boolean isMatchRecursive(int i, int j, String text, String pattern, Boolean[][] dp) {
        //是否已经计算过了
        if (dp[i][j] != null) {
            return dp[i][j].equals(Boolean.TRUE);
        }
        boolean ans;
        //结果兜底
        if (j == pattern.length()) {
            ans = i == text.length();
        }
        else {
            //递归公式
            boolean firstMatch = i < text.length() && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');
            if (pattern.length() > j + 1 && pattern.charAt(j + 1) == '*') {
                ans = firstMatch && isMatchRecursive(i + 1, j, text, pattern, dp) || isMatchRecursive(i, j + 2, text, pattern, dp);
            } else {
                ans = firstMatch && isMatchRecursive(i + 1, j + 1, text, pattern, dp);
            }
        }
        //record
        dp[i][j] = ans;
        return ans;
    }
    /**
     * 自底向上
     * dp[i][j] 表示第 text的 0 到 i-1 和 pattern 的 0 到 j-1 是否相等
     * @param text
     * @param pattern
     * @return
     */
    public boolean isMatchBottomUp(String text, String pattern){
        if(text == null || pattern == null) {
            return false;
        }
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;
        for(int i = text.length(); i >= 0; i--){
            for(int j = pattern.length()-1; j >=0; j--){
                boolean firstMatch = i < text.length()
                        && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');
                if(j+1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = (firstMatch && dp[i+1][j]) || dp[i][j+2];
                }
                else{
                    dp[i][j] = firstMatch && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
