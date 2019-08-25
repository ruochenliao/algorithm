package dynamicProgramming;

public class TestRegularExpressionMatching {
    public static void main(String[] args){
        RegularExpression expression = new RegularExpression();
        boolean result = expression.isMatchRecursion("aaa", "a*a");
        System.out.println(result);
    }
}
