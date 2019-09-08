package dynamicProgramming;

public class UniquePath {
    /**
     * route[i][j]: 记录到点 (i, j) 有多少途径
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n){
        if(m < 1 || n < 1){
            return -1;
        }
        int[][] route = new int[m][n];
        for(int i = 0; i < m; i++){
            route[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            route[0][j] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                route[i][j] = route[i-1][j] + route[i][j-1];
            }
        }
        return route[m-1][n-1];
    }
}
