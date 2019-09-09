package dynamicProgramming;

public class ClimbingStairs {
    /**
     * recursive
     * @param n
     * @return
     */
    public int climbStairsRecursive(int n) {
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        return climbStairsRecursive(n-1) + climbStairsRecursive( n - 2);
    }
    /**
     * recursive dp
     * top to bottom
     * @param remain
     * @return
     */

    public int climbStairsRecursiveDp(int remain, Integer[] dp){
        if(remain == 0){
            return 1;
        }
        if(remain < 0){
            return -1;
        }
        if(dp[remain] != null){
            return dp[remain];
        }
        int steps = climbStairsRecursiveDp(remain - 1, dp) + climbStairsRecursiveDp(remain - 2, dp);
        dp[remain] = steps;
        return steps;
    }

    /**
     * iterative
     * @param n
     * @return
     */
    public int climbStairsIterativeDp(int n) {
        int[] steps = new int[n+1];
        steps[0] = 1;
        steps[1] = 1;
        for(int i = 2; i < n+1; i++){
            steps[i] = steps[i-1] + steps[i-2];
        }
        return steps[n];
    }
}

