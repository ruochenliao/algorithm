package dynamicProgramming;

public class TestMaxSubArray {
    public static void main(String[] args){
        int[] arr = {1,2};
        MaximumSubarray subarray = new MaximumSubarray();
        int result1 = subarray.maxSubArray(arr);
        System.out.println(result1);
    }
}
