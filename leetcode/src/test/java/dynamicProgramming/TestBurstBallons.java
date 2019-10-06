package dynamicProgramming;

public class TestBurstBallons {
    public static void main(String[] args){
        BurstBallons ballons = new BurstBallons();
        int[] nums = {3,1,5,8};
        int result = ballons.maxCoins1(nums);
        System.out.println(result);
        int result2 = ballons.maxCoin2(nums);
        System.out.println(result2);
    }
}
