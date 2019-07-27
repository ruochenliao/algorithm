package dynamicProgramming;

import java.util.Arrays;

/**
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
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1:dp[amount];
    }
}
