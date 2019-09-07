package dynamicProgramming;

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
}
