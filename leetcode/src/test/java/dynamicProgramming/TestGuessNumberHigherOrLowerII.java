package dynamicProgramming;

public class TestGuessNumberHigherOrLowerII {
    public static void main(String[] args){
        GuessNumberHigherOrLowerII lowerII = new GuessNumberHigherOrLowerII();
        int n = 10;
        int result = lowerII.getMoneyAmount(n);
        System.out.println(result);
    }
}
