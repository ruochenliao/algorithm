package dynamicProgramming;

public class TestHouseRobber {
    public static void main(String[] args){
        HouseRobber robber = new HouseRobber();
        int[] arr = {1,2,3,1};
        int result = robber.rob(arr);
        System.out.println(result);
        int result2 = robber.rob2(arr);
        System.out.println(result2);
        int result3 = robber.rob3(arr);
        System.out.println(result3);
    }
}
