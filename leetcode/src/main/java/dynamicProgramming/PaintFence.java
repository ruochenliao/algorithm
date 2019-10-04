package dynamicProgramming;

public class PaintFence {
    /**
     * 违反规定的是三根柱子颜色相同, 所以只要保证连续三根柱子颜色不同即可
     * dp[i]: 从 0 到 i, 有 dp[i] 种paint 的方法
     * dp[i] = (dp[i-1] + dp[i-2]) * (k-1)
     * 第 (i-1) 根柱子有 dp[i-1] 种paint 方法; 如果第 i 根柱子和 (i-1) 根柱子颜色不一样, 不管柱子(i-2), 有 dp[i-1] * (k-1) 种方案
     * 第 (i-2) 根柱子有 dp[i-2] 种paint 方法; 如果第 i 根柱子和 (i-2) 根柱子颜色不一样, 不管柱子(i-1), 有 dp[i-2] * (k-1) 种方案
     * 那么保证连续三根柱子颜色不能相同的方案有 (dp[i-1] + dp[i-2]) * (k-1) 种方案
     * @param n
     * @param k
     * @return
     */
    public int numWays(int n, int k) {
        if(n <= 0 || k <= 0){
            return 0;
        }
        if(n == 1){
            return k;
        }
        if(n == 2){
            return k * k;
        }
        int[] dp = new int[n+1];
        dp[1] = k;
        dp[2] = k * k;
        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) * (k-1);
        }
        return dp[n];
    }
}
