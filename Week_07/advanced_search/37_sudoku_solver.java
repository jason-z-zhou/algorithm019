class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) return;
        solve(board);
    }

    public boolean solve(char[][] board){
        for(int r = 0; r< board.length; r++) {
            for(int c=0; c<board[0].length; c++) {

                if(board[r][c] == '.') {
                    for(char num= '1'; num<='9'; num++) {
                        if(isValid(board, r, c, num)) {
                            board[r][c] = num;
                            if(solve(board)) {
                                return true;
                            } else {
                                board[r][c] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char num) {

        for(int i=0; i<9; i++) {
            if(board[i][col] != '.' && board[i][col] == num) return false;
            if(board[row][i] != '.' && board[row][i] == num) return false;
            if(board[3*(row/3) + i/3][3*(col/3) + i%3] != '.' && board[3*(row/3) + i/3][3*(col/3) + i%3] == num) return false;
        }

        return true;
    }

}
