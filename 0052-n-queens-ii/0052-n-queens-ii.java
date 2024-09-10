class Solution {
    int count = 0;
    char[][] board;
    int n;

    public int totalNQueens(int n) {
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        this.n = n;
        dfs(0);
        return count;
    }

    void dfs(int row) {
        if (row == n) {
            count++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isValid(row, j)) {
                board[row][j] = 'Q';
                dfs(row + 1);
                board[row][j] = '.';
            }
        }
    }

    boolean isValid(int row, int col) {
        // check column
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q')
                return false;
        }
        // top left diagnal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        // top right diagnal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }
}