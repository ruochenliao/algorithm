package dynamicProgramming;

public class HouseRobberII {
    public int rob2(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(
                rob2(0, nums.length - 1, nums, new Integer[nums.length]),
                rob2(1, nums.length, nums, new Integer[nums.length])
        );
    }
    private int rob2(int start, int end, int[] nums, Integer[] dp){
        if(start >= end){
            return 0;
        }
        if(dp[start] != null){
            return dp[start];
        }
        int localMax = Math.max(rob2(start+1, end, nums, dp), nums[start]+ rob2(start+2, end, nums, dp));
        dp[start] = localMax;
        return localMax;
    }
}
