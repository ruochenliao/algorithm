package dynamicProgramming;

public class TestBestTimeToBuyAndSellStockIV {
    public static void main(String[] args){
        int[] arr = {3,2,6,5,0,3};
        int k = 2;
        BestTimeToBuyAndSellStockIV sellStockIV = new BestTimeToBuyAndSellStockIV();
        int result = sellStockIV.maxProfit(k, arr);
        System.out.println(result);
    }
}
