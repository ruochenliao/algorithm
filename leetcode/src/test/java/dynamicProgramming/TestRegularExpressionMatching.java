package dynamicProgramming;

public class TestRegularExpressionMatching {
    public static void main(String[] args){
        RegularExpression expression = new RegularExpression();
        boolean result = expression.isMatch("aa", ".*");
        System.out.println(result);

        boolean recursiveResult = expression.isMatchRecursive("aa", ".*");
        System.out.println(recursiveResult);
    }
}
