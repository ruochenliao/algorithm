package dynamicProgramming;

public class ClimbingStairs {
    /**
     * recursive dp
     * top to bottom
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        return climbStairsRecursive(int remain, new Integer[n])
    }
    public int climbStairsRecursive(int remain, Integer[] dp){
        if(remain == 0){
            return 1;
        }
        if(remain < 0){
            return -1;
        }
        if(dp[remain] != null){
            return dp[remain];
        }
        int steps = climbStairsRecursive(remain - 1, dp) + climbStairsRecursive(remain - 2, dp);
        dp[remain] = steps;
        return steps;
    }

}

