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

    /**
     * stack
     * 把 -1 标志着初始长度 0 - (-1) = 1
     * 如果 stack pop 出去为空, 那么把 ) 的 index 推到 stack 里, 那么 i - index 就是i 到index 的下一个 index 的长度
     * @param s
     * @return
     */
    public int longestValidParenthesesStack(String s){
        Stack<Integer> stack = new Stack<>();
        int maxLength = 0;
        stack.push(-1);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                maxLength = Math.max(maxLength, i - stack.peek());
            }
        }
        return maxLength;
    }

    /**
     * two pointer
     * 如果遇到 "(" left++,
     * 如果遇到 ")" right++,
     * 如果 right > left 则 left = right = 0
     * 如果 left == right 那么长度是 left*2
     * @param s
     * @return
     */
    public int longestValidParenthesesTwoPointer(String s){
        int left, right;
        left = right = 0;
        int maxLength = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                left++;
            }
            if(s.charAt(i) == ')'){
                right++;
            }
            if(right > left){
                left = right = 0;
            }
            else if(left == right){
                maxLength = Math.max(maxLength, left*2);
            }
        }
        left = right = 0;
        for(int i = s.length() -1; i >=0; i--){
            if(s.charAt(i) == '('){
                left++;
            }
            if(s.charAt(i) == ')'){
                right++;
            }
            if(right < left){
                left = right = 0;
            }
            else if(left == right){
                maxLength = Math.max(maxLength, left*2);
            }
        }
        return maxLength;
    }
}
