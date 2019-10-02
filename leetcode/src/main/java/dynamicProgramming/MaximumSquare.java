package dynamicProgramming;

/**
 * 221. Maximal Square
 * Medium
 *
 * 1642
 *
 * 41
 *
 * Favorite
 *
 * Share
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 */
public class MaximumSquare {
    /**
     * dp[i][j]: 从 matrix 在点(i-1,j-1) 之前遇到的最大的 square 的 length
     * 取边长最短的那个作为正方形的边长
     * if(matrix[i][j] == '1'){}
     *  dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1;
     * }
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int globalMaxLeng = 0;
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(matrix[i-1][j-1] == '1'){
                    int maxLen = Math.min(dp[i-1][j], dp[i][j-1]);
                    dp[i][j] = Math.min(maxLen, dp[i-1][j-1]) + 1;
                    globalMaxLeng = Math.max(globalMaxLeng, dp[i][j]);
                }
            }
        }
        return globalMaxLeng*globalMaxLeng;
    }
}
