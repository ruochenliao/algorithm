package dynamicProgramming;

public class TestCombinationSumIV {
    public static void main(String[] args){
        CombinationSumIV sumIV = new CombinationSumIV();
        int[] nums = {1, 2, 3};
        int target = 4;
        int result = sumIV.combinationSum4(nums, target);
        System.out.println(result);
    }
}
