package greedy;

/**
 * 123. Best Time to Buy and Sell Stock III
 * Hard
 *
 * 1340
 *
 * 57
 *
 * Favorite
 *
 * Share
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *              Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStockIII {
    /**
     * greedy 思想
     * 两次购买股票
     * 如果第一次买到低点， 卖到最高点; 然后用赚到的钱去买第二次最低点的股票, 第二次卖到最高点;
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int oneBuy = Integer.MAX_VALUE;
        int oneBuyOneSell = 0;
        int twoBuy = Integer.MIN_VALUE;
        int twoBuyTwoSell = 0;
        for(int i = 0; i < prices.length; i++){
            oneBuy = Math.min(oneBuy, prices[i]);       // 第一次以最低价格买入
            oneBuyOneSell = Math.max(oneBuyOneSell, prices[i] - oneBuy);        //以最高价格卖出
            twoBuy = Math.max(twoBuy, oneBuyOneSell - prices[i]);               //第二次以最低价格买入, 获得最大剩下的钱
            twoBuyTwoSell = Math.max(twoBuyTwoSell, prices[i] + twoBuy);        //把剩下的钱 + 卖出的钱就得到所有的 profits
        }
        return twoBuyTwoSell;
    }
}
