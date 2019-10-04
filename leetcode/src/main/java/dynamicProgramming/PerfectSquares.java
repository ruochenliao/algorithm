package dynamicProgramming;

public class PerfectSquares {
    public int numSquares(int n) {
        Integer[] dp = new Integer[n+1];
        return numSquares(n, dp);
    }

    /**
     *
     * @param n
     * @param dp dp[n]: 到 n 至少需要 dp[n]
     * @return n 至少需要的数
     */
    public int numSquares(int n, Integer[] dp) {
        if(n == 0){
            return 0;
        }
        if(dp[n] != null){
            return dp[n];
        }
        int minNum = Integer.MAX_VALUE;
        for(int i = 1; i * i <= n; i++){
            int num = numSquares(n - i * i, dp) + 1;
            minNum = Math.min(minNum, num);
        }
        dp[n] = minNum;
        return minNum;
    }
}
