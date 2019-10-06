package dynamicProgramming;

public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int counter = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '0'){
                    counter = Math.max(counter, maxKill(grid, i, j));
                }
            }
        }
        return counter;
    }

    private int maxKill(char[][] grid, int row, int col) {
        int enemyCount = 0;
        for(int i = row + 1; i < grid.length; i++){
            if(grid[i][col] == 'W'){
                break;
            }
            if(grid[i][col] == 'E'){
                enemyCount++;
            }
        }
        for(int i = row - 1; i >= 0; i--){
            if(grid[i][col] == 'W'){
                break;
            }
            if(grid[i][col] == 'E'){
                enemyCount++;
            }
        }
        for(int j = col + 1; j < grid[0].length; j++){
            if(grid[row][j] == 'W'){
                break;
            }
            if(grid[row][j] == 'E'){
                enemyCount++;
            }
        }
        for(int j = col - 1; j >= 0; j--){
            if(grid[row][j] == 'W'){
                break;
            }
            if(grid[row][j] == 'E'){
                enemyCount++;
            }
        }
        return enemyCount;
    }
}
