package dynamicProgramming;

import java.util.Arrays;

/**
 *
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 *
 * dp[i] 表示组成钱 i 所需要的最少的零钱数
 *
 * for(int j = 0; j < coins.length; j++){
 *      dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
 * }
 *
 */
public class CoinChangeSolution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE -1 );
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length && i >= coins[j]; j++){
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1:dp[amount];
    }
}
