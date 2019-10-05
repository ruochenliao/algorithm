package dynamicProgramming;

/**
 * 304. Range Sum Query 2D - Immutable
 * Medium
 *
 * 564
 *
 * 142
 *
 * Favorite
 *
 * Share
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 *
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 *
 * Example:
 * Given matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 */
public class NumMatrix {
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        sum = new int[m+1][n+1];
        int[] dp = new int[n];
        for(int i = 0; i < m; i++){
            int localSum = 0;
            for(int j = 0; j < n; j++){
                dp[j] += matrix[i][j];
                localSum += dp[j];
                sum[i+1][j+1] = localSum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1][col2+1] + sum[row1][col1];
    }
}
