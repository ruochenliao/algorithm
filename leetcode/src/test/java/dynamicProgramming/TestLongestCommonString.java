package dynamicProgramming;

public class TestLongestCommonString {
    public static void main(String[] args){
        LongestCommonString longestCommonString = new LongestCommonString();
        String s1 = "abcbdab";
        String s2 = "bdcaba";
        String result = longestCommonString.getLongestCommonStr(s1, s2);
        System.out.println(result);
    }
}
