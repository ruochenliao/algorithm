package dfs;

/**
 * 130. Surrounded Regions
 * Medium
 *
 * 974
 *
 * 499
 *
 * Favorite
 *
 * Share
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        Boolean[][] mark = new Boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            markBoard(board, mark, i, 0);
            markBoard(board, mark, i, board[0].length - 1);
        }
        for(int j = 0; j < board[0].length; j++){
            markBoard(board, mark, 0, j);
            markBoard(board, mark, board.length - 1, j);
        }
        for(int i = 1; i < board.length -1; i++){
            for(int j = 1; j < board[0].length - 1; j++){
                flip(board, mark, i, j);
            }
        }
    }
    private void markBoard(char[][] board, Boolean[][] mark, int i, int j){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || 'X' == board[i][j] || Boolean.TRUE.equals(mark[i][j])){
            return;
        }
        if(board[i][j] == 'O'){
            mark[i][j] = true;
            markBoard(board, mark, i+1, j);
            markBoard(board, mark, i, j+1);
            markBoard(board, mark, i-1, j);
            markBoard(board, mark, i, j-1);
        }
    }
    private void flip(char[][] board, Boolean[][] mark, int i, int j){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || 'X' == board[i][j] || Boolean.TRUE.equals(mark[i][j])){
            return;
        }
        if(board[i][j] == 'O'){
            board[i][j] = 'X';
            mark[i][j] = true;
            flip(board, mark, i+1, j);
            flip(board, mark, i, j+1);
            flip(board, mark, i-1, j);
            flip(board, mark, i, j-1);
        }
    }
}
