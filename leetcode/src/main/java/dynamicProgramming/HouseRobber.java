package dynamicProgramming;

/**
 * 198. House Robber
 * Easy
 *
 * 3062
 *
 * 95
 *
 * Favorite
 *
 * Share
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Integer[] dp1 = new Integer[nums.length];
        Integer[] dp2 = new Integer[nums.length];
        int rob1 = rob(0, nums, dp1);
        int rob2 = rob(1, nums, dp2);
        return Math.max(rob1, rob2);
    }

    private int rob(int i, int[] nums, Integer[] dp){
        if(i >= nums.length){
            return 0;
        }
        if(dp[i] != null){
            return dp[i];
        }
        int maxRob = 0;
        for(int j = i; j < nums.length; j++){
            int localMax = nums[i] + rob(j + 2, nums, dp);
            maxRob = Math.max(maxRob, localMax);
        }
        dp[i] = maxRob;
        return maxRob;
    }

    public int rob2(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        return rob2(0, nums, new Integer[nums.length]);
    }

    private int rob2(int i, int[] nums, Integer[] dp){
        if(i >= nums.length){
            return 0;
        }
        if(dp[i] != null){
            return dp[i];
        }
        int localMax = Math.max(rob2(i+1, nums, dp), nums[i]+ rob2(i+2, nums, dp));
        dp[i] = localMax;
        return localMax;
    }

    public int rob3(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = nums[nums.length - 1];
        dp[nums.length - 2] = nums[nums.length - 2];
        for(int i = nums.length - 3; i >= 0; i--){
            dp[i] = Math.max(dp[i+1], nums[i] + dp[i+2]);
        }
        return dp[0];
    }
}
