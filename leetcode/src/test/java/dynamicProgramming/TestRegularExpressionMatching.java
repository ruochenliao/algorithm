package dynamicProgramming;

public class TestRegularExpressionMatching {
    public static void main(String[] args){
        RegularExpression expression = new RegularExpression();
        boolean result = expression.isMatch("aa", ".*");
        System.out.println(result);

        boolean recursiveResult = expression.isMatchRecursive("aa", ".*");
        System.out.println(recursiveResult);
        boolean iterationResult = expression.isMatchIteration("aa", ".*");
        System.out.println(iterationResult);
        boolean result2 = expression.isMatchBottomUp("aa","a");
        System.out.println(result2);
    }
}
