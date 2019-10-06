package dynamicProgramming;

/**
 * 312. Burst Balloons
 * Hard
 *
 * 1612
 *
 * 50
 *
 * Favorite
 *
 * Share
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 *
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Note:
 *
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * Example:
 *
 * Input: [3,1,5,8]
 * Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *              coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class BurstBallons {
    /**
     * O(n^3)
     * @param nums
     * @return
     */
    public int maxCoins1(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        boolean[] marks = new boolean[nums.length];
        return maxCoins1(marks,nums);
    }
    /**
     * int coin = left * nums[i] * right + maxCoins1(marks, nums);
     * maxCoin = Math.max(maxCoin, coin);
     *
     * @param marks
     * @param nums
     * @return
     */
    private int maxCoins1(boolean[] marks, int[] nums){
        boolean isAllMarked = true;
        for(boolean mark:marks){
            isAllMarked = isAllMarked && mark;
        }
        if(isAllMarked){
            return 0;
        }
        int maxCoin = 0;
        for(int i = 0; i < nums.length; i++){
            if(marks[i]){
                continue;
            }
            int left = 1;
            for(int j = i - 1; j >= 0; j--){
                if(marks[j]){
                    continue;
                }
                left = nums[j];
                break;
            }
            int right = 1;
            for(int j = i + 1; j < nums.length; j++){
                if(marks[j]){
                    continue;
                }
                right = nums[j];
                break;
            }
            marks[i] = true;
            int coin = left * nums[i] * right + maxCoins1(marks, nums);
            marks[i] = false;
            maxCoin = Math.max(maxCoin, coin);
        }
        return maxCoin;
    }

    public int maxCoin2(int[] nums){
        int m = nums.length;
        int[] arr = new int[m+2];
        arr[0] = arr[m+1] = 1;
        for(int i = 0; i < nums.length; i++){
            arr[i+1] = nums[i];
        }
        Integer[][] dp = new Integer[m+2][m+2];
        return maxCoin2(0, m+1, arr, dp);
    }

    /**
     * Divide conquer + dp
     *
     * @param left
     * @param right
     * @param nums
     * @return 从 left 到 right exclusive, (left, right) 最多可以获得的钱
     */
    public int maxCoin2(int left, int right, int[] nums, Integer[][] dp){
        if(left == right){
            return 0;
        }
        if(dp[left][right] != null){
            return dp[left][right];
        }
        int maxCoin = 0;
        for(int i = left + 1; i < right; i++){
            int coin = nums[left] * nums[i] * nums[right]
                    + maxCoin2(left, i, nums, dp) + maxCoin2(i, right, nums, dp);
            maxCoin = Math.max(maxCoin, coin);
        }
        dp[left][right] = maxCoin;
        return maxCoin;
    }
}
