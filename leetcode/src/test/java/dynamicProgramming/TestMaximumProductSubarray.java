package dynamicProgramming;

public class TestMaximumProductSubarray {
    public static void main(String[] args){
        int[] nums = {-1,-2,-9,-6};
        MaximuProductSubarray productSubarray = new MaximuProductSubarray();
        int result = productSubarray.maxProduct(nums);
        int result1 = productSubarray.maxProductWith1Space(nums);
        System.out.println(result);
        System.out.println(result1);
    }
}
