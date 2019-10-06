package dynamicProgramming;

public class TestIntegerBreak {
    public static void main(String[] args){
        IntegerBreak integerBreak = new IntegerBreak();
        int n = 10;
        int result1 = integerBreak.integerBreak(n);
        System.out.println(result1);
        int result2 = integerBreak.integerBreakIterative(n);
        System.out.println(result2);
    }
}
