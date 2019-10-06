package dynamicProgramming;

/**
 * 377. Combination Sum IV
 * Medium
 *
 * 940
 *
 * 112
 *
 * Favorite
 *
 * Share
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 *
 * Example:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * Note that different sequences are counted as different combinations.
 *
 * Therefore the output is 7.
 *
 *
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 *
 * Credits:
 * Special thanks to @pbrother for adding this problem and creating all test cases.
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Integer[] dp = new Integer[target+1];
        return combinationSum4Recursive(nums, target, dp);
    }

    /**
     *
     * @param nums
     * @param target
     * @return 以 nums 为基础, 组成 target, 有 返回值那么多 种组合方式
     */
    public int combinationSum4Recursive(int[] nums, int target, Integer[] dp){
        if(target < 0){
            return 0;
        }
        if(dp[target] != null){
            return dp[target];
        }
        if(target == 0){
            return 1;
        }
        int sum = 0;
        for(int num: nums){
            sum += combinationSum4Recursive(nums, target - num, dp);
        }
        dp[target] = sum;
        return sum;
    }
}
