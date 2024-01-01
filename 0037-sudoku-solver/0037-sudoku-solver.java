class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board);
    }

    boolean dfs(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.')
                    continue;
                for (char k = '1'; k <= '9'; k++) {
                    if (!isValid(board, i, j, k))
                        continue;
                    board[i][j] = k;
                    if (dfs(board))
                        return true;
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }

    boolean isValid(char[][] board, int row, int col, char k) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == k)
                return false;
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == k)
                return false;
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == k)
                    return false;
            }
        }
        return true;
    }
}