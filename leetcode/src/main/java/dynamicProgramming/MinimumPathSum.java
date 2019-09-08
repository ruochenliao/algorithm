package dynamicProgramming;

/**
 * 64. Minimum Path Sum
 * Medium
 *
 * 1603
 *
 * 43
 *
 * Favorite
 *
 * Share
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid[0] == null){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];
        for(int i = 1; i < m; i++){
            sum[i][0] = grid[i-1][0] + sum[i-1][0];
        }
        for(int j = 1; j < n; j++){
            sum[0][j] = grid[0][j-1] + sum[0][j-1];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                sum[i][j] = Math.min(grid[i-1][j] + sum[i-1][j], grid[i][j-1] + sum[i][j-1]);
            }
        }
        return sum[m-1][n-1] + grid[m-1][n-1];
    }
}
