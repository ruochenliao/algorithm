package dynamicProgramming;

public class TestCoinChange {
    public static void main(String[] args){
        CoinChangeSolution coin = new CoinChangeSolution();
        int[] coins = {2};
        int numOfChange = coin.coinChange(coins, 9);
        System.out.println("result " + numOfChange);
    }
}
