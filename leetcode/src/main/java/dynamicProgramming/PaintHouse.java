package dynamicProgramming;

public class PaintHouse {

    public int minCost(int[][] costs) {
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
        for(int j = 0; j < 3; j++){
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
}
