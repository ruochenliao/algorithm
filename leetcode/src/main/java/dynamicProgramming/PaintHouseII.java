package dynamicProgramming;

public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0){
            return 0;
        }
        Integer[][] dp = new Integer[costs.length][costs[0].length];
        return minCostRecursive(costs, 0, -1, dp);
    }
    /**
     * 返回 iIndex + 1 到 costs[0].length 这些层花费最少的钱去 paint house
     * @param costs
     * @param iIndex
     * @param jIndex
     * @param dp dp[i][j] ：如果选择 costs[i][j], 所花费的最少的钱去 paint house
     * @return
     */
    private int minCostRecursive(int[][] costs, int iIndex, int jIndex, Integer[][] dp){
        if(iIndex >= costs.length){
            return 0;
        }
        if(jIndex != -1 && dp[iIndex][jIndex] != null){
            return dp[iIndex][jIndex];
        }
        int minCost = Integer.MAX_VALUE;
        for(int j = 0; j < costs[0].length; j++){
            if(jIndex != j){
                int cost = costs[iIndex][j] + minCostRecursive(costs, iIndex+1, j, dp);
                minCost = Math.min(minCost, cost);
            }
        }
        if(jIndex != - 1){
            dp[iIndex][jIndex] = minCost;
        }
        return minCost;
    }

    /**
     * dp[i][j] 表示选中点 (i,j) 到选完最少需要花 dp[i][j] 这么多钱
     * @param costs
     * @return
     */
    public int minCostIterative(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0){
            return 0;
        }
        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = new int[m][n];
        for(int j = 0; j < n; j++){
            dp[m-1][j] = costs[m-1][j];
        }
        for(int i = m - 2; i >= 0; i--){
            for(int j = 0; j < n; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = 0; k < n; k++){
                    if(k != j){
                        dp[i][j] = Math.min(dp[i][j], costs[i][j] + dp[i+1][k]);
                    }
                }
            }
        }
        int minCost = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            minCost = Math.min(minCost, dp[0][j]);
        }
        return minCost;
    }
}
