package dynamicProgramming;

/**
 * Longest Palindromic Substring
 * Medium
 *
 * 4155
 *
 * 386
 *
 * Favorite
 *
 * Share
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPandlindromicSubstring {
    private static int GLOBAL_START = 0;
    private static int GLOBAL_END = 0;
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2){
            return s;
        }
        for(int i = 0; i < s.length(); i++){
            findLengest(i, i, s);
            findLengest(i,i+1, s);
        }
        return s.substring(GLOBAL_START+1, GLOBAL_END);
    }
    private void findLengest(int start, int end, String s){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        if(end - start > GLOBAL_END - GLOBAL_START){
            GLOBAL_START = start;
            GLOBAL_END = end;
        }
    }
}
