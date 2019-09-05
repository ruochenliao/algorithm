package dynamicProgramming;

public class TestLongestParanthese {
    public static void main(String[] args){
        LongestParenthese obj = new LongestParenthese();
        String str = "()()";
        int result1 = obj.longestValidParenthesesBruteForce(str);
        System.out.println(result1);
        int result2 = obj.longestValidParenthesesDp(str);
        System.out.println(result2);
    }
}
