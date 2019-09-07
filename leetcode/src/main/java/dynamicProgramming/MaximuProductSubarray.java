package dynamicProgramming;

public class MaximuProductSubarray {
    /**
     * minimum[i] 表示以 nums[i] 为结尾的连续相乘的最小的值
     * maximum[i] 表示以 nums[i] 为结尾的连续相乘的最大的值
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] minimum = new int[nums.length];
        int[] maximum = new int[nums.length];
        minimum[0] = nums[0];
        maximum[0] = nums[0];
        int globalMax = nums[0];
        for(int i = 1; i < nums.length; i++){
            minimum[i] = Math.min(nums[i] * minimum[i-1], nums[i]);
            minimum[i] = Math.min(nums[i] * maximum[i-1], minimum[i]);
            maximum[i] = Math.max(nums[i] * maximum[i-1], nums[i]);
            maximum[i] = Math.max(nums[i] * minimum[i-1], maximum[i]);
            globalMax = Math.max(globalMax, maximum[i]);
        }
        return globalMax;
    }

    public int maxProductWith1Space(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int minimum = nums[0];
        int maximum = nums[0];
        int globalMax = nums[0];
        for(int i = 1; i < nums.length; i++){
            int preMin = minimum;
            minimum = Math.min(nums[i] * minimum, nums[i]);
            minimum = Math.min(nums[i] * maximum, minimum);
            maximum = Math.max(nums[i] * maximum, nums[i]);
            maximum = Math.max(nums[i] * preMin, maximum);
            globalMax = Math.max(globalMax, maximum);
        }
        return globalMax;
    }
}
