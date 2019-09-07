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
    /**
     * 递归穷举步骤
     * 1. 设置边界条件
     * 2. 写递归公式
     * @param coins
     * @param amount
     * @return
     */
    public int coinChangRecursive(int[] coins, int amount){
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        int localMin = Integer.MAX_VALUE;
        for(int coin:coins){
            int remCount = coinChangRecursive(coins, amount - coin);
            if(remCount == -1){
                continue;
            }
            localMin = Math.min(localMin, 1+remCount);
        }
        return localMin == Integer.MAX_VALUE ? -1: localMin;
    }

    /**
     * dp[i] 从 i 到 amount 使用最少的零钱数
     * 1.
     * @param coins
     * @param amount
     * @return
     */
    public int coinChangeRecursiveDp(int[] coins, int amount){
        Integer[] dp = new Integer[amount + 1];
        return coinChangRecursiveDp(coins, dp, amount);
    }

    public int coinChangRecursiveDp(int[] coins, Integer[] dp, int remain){
        if(remain == 0){
            return 0;
        }
        if(remain < 0){
            return -1;
        }
        if(dp[remain] != null){
            return dp[remain];
        }
        int localMin = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            int remCount = coinChangRecursiveDp(coins, dp, remain - coins[i]);
            if(remCount == -1){
                continue;
            }
            localMin = Math.min(localMin, 1+remCount);
        }
        dp[remain] = localMin == Integer.MAX_VALUE ? -1: localMin;
        return dp[remain];
    }

    /**
     * iterative dp
     * @param coins
     * @param amount
     * @return
     */
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
