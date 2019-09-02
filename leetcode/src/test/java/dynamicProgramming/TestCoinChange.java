package dynamicProgramming;

public class TestCoinChange {
    public static void main(String[] args){
        CoinChangeSolution coin = new CoinChangeSolution();
        int[] coins = {1,2,5};
        int amount = 100;
        int numOfChange = coin.coinChange(coins, amount);
        System.out.println("result " + numOfChange);
        int changeRecursive = coin.coinChangeRecursiveDp(coins, amount);
        System.out.println(changeRecursive);
        int result = coin.coinChangRecursive(coins, amount );
        System.out.println("result" + result);
    }
}
