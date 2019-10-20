package dfs;

public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        int counter = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(markPoint(grid, i, j)){
                    counter++;
                }
            }
        }
        return counter;
    }
    private boolean markPoint(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || '1' != grid[i][j]){
            return false;
        }
        grid[i][j] = '2';
        markPoint(grid, i + 1, j);
        markPoint(grid, i, j + 1);
        markPoint(grid, i - 1, j);
        markPoint(grid, i, j - 1);
        return true;
    }
}
