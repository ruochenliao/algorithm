package dynamicProgramming;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Integer[][] dp = new Integer[nums.length+1][nums.length];
        return lengthOfLIS(-1,0,  nums, dp);
    }

    /**
     *
     * @param prevIndex
     * @param index
     * @param nums
     * @param dp 以 index 为起始, (nums.length - 1) 为结束, nums[prevIndex] 为不断增长的前面一个数, 连续增加的最多的个数
     * @return 以 index 为起始, prevIndex 为之前的数, 到 end 连续增加的最多的个数
     */
    private int lengthOfLIS(int prevIndex, int index, int[] nums, Integer[][] dp){
        if(index == nums.length){
            return 0;
        }
        if(dp[prevIndex+1][index] != null){
            return dp[prevIndex+1][index];
        }
        int maxCount;
        int count1 = 0;
        if(prevIndex < 0 || nums[index] > nums[prevIndex]){
            count1 = lengthOfLIS(index,index + 1, nums, dp) + 1;
        }
        int count2 = lengthOfLIS(prevIndex, index+1, nums, dp);
        maxCount = Math.max(count1, count2);
        dp[prevIndex+1][index] = maxCount;
        return maxCount;
    }

    /**
     * dp[i] 从 0 到 i, 包括 nums[i] 在内连续 increasing 数的数量
     * @param nums
     * @return
     */
    public int lengthOfLISIterative(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int m = nums.length;
        int[] dp = new int[m];
        int maxNum = 0;
        for(int i = 0; i < m; i++){
            int localMax = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    localMax = Math.max(localMax, dp[j] + 1);
                }
            }
            dp[i] = localMax;
            maxNum = Math.max(maxNum, dp[i]);
        }
        return maxNum;
    }
}
