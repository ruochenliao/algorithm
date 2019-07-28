package dynamicProgramming;

public class TestCuttingRod {
    public static void main(String[] args){
        CuttingRod cuttingRod = new CuttingRod();
        int[] arr = {1,5,8,9};
        int maxProfit = cuttingRod.maxProfitsOfCutRod(4, arr);
        System.out.println(maxProfit);
    }
}
