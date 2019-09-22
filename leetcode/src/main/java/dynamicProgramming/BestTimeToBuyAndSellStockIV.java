package dynamicProgramming;

public class BestTimeToBuyAndSellStockIV {
    /**
     * dp[i][j] 通过 ith 次交易, jth 天, 能赚得最多的钱
     * dp[i][j] = Math.max(dp[i-1][j-1], localMax + prices[j]); 当前赚得最多的钱 = 我什么也不操作, 或者我卖掉股票, localMax 用来记录如果昨天的钱用来买股票还剩多少钱
     * localMax = Math.max(localMax, dp[i-1][j-1] - prices[j]);
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0 || k < 1){
            return 0;
        }
        if(2*k >= prices.length){
            return transactionAsRequired(prices);
        }
        int[][] dp = new int[k+1][prices.length];
        for(int i = 1; i <= k; i++){
            int localMax = -prices[0];
            for(int j = 1; j < prices.length; j++){
                dp[i][j] = Math.max(dp[i][j-1], localMax + prices[j]);//如果卖股票
                localMax = Math.max(localMax, dp[i-1][j-1] - prices[j]);//如果用上次交易赚得的钱买股票
            }
        }
        return dp[k][prices.length-1];
    }

    /**
     * 如果可以自由交易的话, 那么求差值就行了
     * @param prices
     * @return
     */
    private int transactionAsRequired(int[] prices) {
        int maxDiff = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                maxDiff += prices[i] - prices[i-1];
            }
        }
        return maxDiff;
    }
}
