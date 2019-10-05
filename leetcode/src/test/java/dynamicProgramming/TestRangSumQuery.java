package dynamicProgramming;

public class TestRangSumQuery {
    public static void main(String[] args){
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        int result = numArray.sumRange(2,5);
        System.out.println(result);
    }
}
