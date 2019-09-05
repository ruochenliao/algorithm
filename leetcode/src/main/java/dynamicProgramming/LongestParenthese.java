package dynamicProgramming;

import java.util.Stack;

public class LongestParenthese {
    /**
     * brute force
     * @param s
     * @return
     */
    public int longestValidParenthesesBruteForce(String s) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j += 1) {
                if (isValid(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }



    /**
     * dp
     * dp[i] 代表 [ i - j, i] 满足 最长括号的长度
     * 如果遇到 ")" 则认为是结尾
     * if(s.charAt(i-1) == '('){
     *     dp[i] = 2 + dp[i-2];
     * }
     * if(s.charAt(i-dp[i-1]-1) == '('){
     *     dp[i] = 2 + dp[i-1] + dp[i-d[i-1]-2];
     * }
     * 最后比较出最大值
     * maxLength = Math.max(maxLength, dp[i]);
     * @param s
     * @return
     */
    public int longestValidParenthesesDp(String s) {
        int[] dp = new int[s.length()];
        int maxLength = 0;
        for(int i = 0; i < s.length();  i++){
            if(s.charAt(i) == ')'){
                if(i - 1 >= 0 && s.charAt(i-1) == '('){
                    dp[i] = (i - 2 >= 0? dp[i-2] : 0) + 2;
                }
                else if(i - 1 > 0 && i - dp[i-1] - 1 >= 0 && s.charAt(i - dp[i-1] - 1) == '('){
                    dp[i] = 2+ dp[i-1] + ((i - dp[i-1] - 2) >= 0? dp[i - dp[i-1] - 2]:0);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

}
