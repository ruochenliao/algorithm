package dynamicProgramming;

public class BestTimeToBuyAndSellStock {
    /**
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++){
            min = Math.min(prices[i], min);
            maxDiff = Math.max(prices[i] - min, maxDiff);
        }
        return maxDiff;
    }
}
