package dynamicProgramming;

/**
 * 10. Regular Expression Matching
 Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.
 The matching should cover the entire input string (not partial).

 Note:

 s could be empty and contains only lowercase letters a-z.
 p could be empty and contains only lowercase letters a-z, and characters like . or *.
 Example 1:

 Input:
 s = "aa"
 p = "a"
 Output: false
 Explanation: "a" does not match the entire string "aa".
 Example 2:

 Input:
 s = "aa"
 p = "a*"
 Output: true
 Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 Example 3:

 Input:
 s = "ab"
 p = ".*"
 Output: true
 Explanation: ".*" means "zero or more (*) of any character (.)".
 Example 4:

 Input:
 s = "aab"
 p = "c*a*b"
 Output: true
 Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 Example 5:

 Input:
 s = "mississippi"
 p = "mis*is*p*."
 Output: false
 */
public class RegularExpression {
    //recursion method
    public boolean isMatchRecursion(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean firstMatch = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
        if(pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (firstMatch && isMatchRecursion(text.substring(1), pattern))
                    || isMatchRecursion(text, pattern.substring(2));
        }
        else{
            return firstMatch && isMatchRecursion(text.substring(1), pattern.substring(1));
        }
    }

    //iterative method
    public boolean isMatchIterative(String text, String pattern){
        boolean dp[][] = new boolean[text.length() + 1][pattern.length() + 1];
        for(int i = 0; i < text.length(); i++){
            for(int j = 0; j < pattern.length(); j++){
                boolean first
            }
        }
    }
}
