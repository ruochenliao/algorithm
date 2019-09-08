package dynamicProgramming;

public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        if(obstacleGrid == null || obstacleGrid[0] == null){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] route = new int[m][n];
        for(int i = 0; i < m; i++){
            if(obstacleGrid[i][0] != 0){
                break;
            }
            route[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            if(obstacleGrid[0][j] != 0){
                break;
            }
            route[0][j] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j <n; j++){
                int left = obstacleGrid[i-1][j] == 1? 0:route[i-1][j];
                int up = obstacleGrid[i][j-1] == 1? 0:route[i][j-1];
                route[i][j] = obstacleGrid[i][j] == 1?0:left + up;
            }
        }
        return route[m-1][n-1];
    }
}
