package dynamicProgramming;

/**
 * 53. Maximum Subarray
 * Easy
 *
 * 7295
 *
 * 334
 *
 * Add to List
 *
 * Share
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {
    /**
     * sum[i] 表示以 nums[i] 为结尾的并包含 nums[i] 的连续相加的最大值
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] sum = new int[nums.length];
        int max = nums[0];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum[i] = Math.max(nums[i], nums[i] + sum[i-1]);
            max = Math.max(sum[i], max);
        }
        return max;
    }

    /**
     * dp with O(1) space
     * @param nums
     * @return
     */
    public int maxSubArrayWith1Space(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum = Math.max(nums[i], nums[i] + sum);
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int oNSpaceResult = maximumSubarray.maxSubArray(arr);
        int o1SpaceResult = maximumSubarray.maxSubArrayWith1Space(arr);
        System.out.println("oNSpaceResult " + oNSpaceResult);
        System.out.println("o1SpaceResult " + o1SpaceResult);
    }
}
