package dfs;

/**
 * 200. Number of Islands
 * Medium
 *
 * 5012
 *
 * 190
 *
 * Add to List
 *
 * Share
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
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
