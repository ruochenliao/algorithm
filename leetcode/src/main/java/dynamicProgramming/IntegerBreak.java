package dynamicProgramming;

public class IntegerBreak {
    public int integerBreak(int n) {
        if(n == 2|| n == 3){
            return n-1;
        }
        Integer[] dp = new Integer[n+1];
        return integerBreakRecursive(n, dp);
    }

    /**
     *
     * @param n
     * @param dp dp[i] 存储 i 到 end divide multiply 以后乘积数最大的值
     * @return i 到 end divide multiply 以后乘积数最大
     */
    private int integerBreakRecursive(int n, Integer[] dp){
        if(n < 2){
            return 1;
        }
        if(dp[n] != null){
            return dp[n];
        }
        int maxMultiply = 0;
        for(int i = 1; i < n + 1; i++){
            int multiply = i * integerBreakRecursive(n-i, dp);
            maxMultiply = Math.max(maxMultiply, multiply);
        }
        dp[n] = maxMultiply;
        return maxMultiply;
    }

    public int integerBreakIterative(int n){
        if(n == 2|| n == 3){
            return n-1;
        }
        int[] dp = new int[n+1]; // dp[i] 数字 i 能分解成乘积最大的数值
        int globalMax = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i < n + 1; i++){
            int localMax = 0;
            for(int j = 1; j < i; j++){
                localMax = Math.max(localMax, dp[j] * dp[i-j]);
            }
            dp[i] = localMax;
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }
}
