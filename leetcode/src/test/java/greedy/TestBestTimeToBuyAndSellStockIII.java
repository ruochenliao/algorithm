package greedy;

public class TestBestTimeToBuyAndSellStockIII {
    public static void main(String[] args){
        BestTimeToBuyAndSellStockIII stockIII = new BestTimeToBuyAndSellStockIII();
        int[] arr = {1, 0, 2, 1, 3,2,4};
        int result = stockIII.maxProfit(arr);
        System.out.println(result);
    }
}
