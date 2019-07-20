package greedy;

/**
 * 44. Wildcard Matching
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 *
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * Example 4:
 *
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * Example 5:
 *
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 *
 *
 * p 遇到下面的时候
 * {
 *      ?, 相等: i++; j++
 *      *: 记录anchor
 *      others:{
 *      遇到过 *: 回到 anchor;
 *      没遇到过 *: return false;
 * }
 * 补偿: 当 j < p.length 最后几个字母可能没有匹配到
 * }
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p){
        int i = 0;
        int j = 0;
        int iAnchor = 0;
        int jAnchor = 0;
        while(i < s.length()){
            if(j < p.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))){
                i++;
                j++;
            }
            else if(p.charAt(j) == '*'){
                iAnchor = i;
                jAnchor = j;
                j++;
            }
            else if(jAnchor != 0){
                i++;
                iAnchor = i;
                j = jAnchor;
                j++;
            }
            else{
                return false;
            }
        }
        while(j < p.length()){
            if(p.charAt(j) != '*'){
                return false;
            }
        }
        return true;
    }
}
