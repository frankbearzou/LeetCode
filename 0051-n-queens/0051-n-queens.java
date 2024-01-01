class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(board, 0, ans);
        return ans;
    }

    void dfs(char[][] board, int row, List<List<String>> ans) {
        if (row == board.length) {
            List<String> list = new ArrayList<>();
            for (char[] arr : board) {
                list.add(new String(arr));
            }
            ans.add(list);
        }
        for (int col = 0; col < board.length; col++) {
            if (!isValid(board, row, col))
                continue;
            board[row][col] = 'Q';
            dfs(board, row + 1, ans);
            board[row][col] = '.';
        }
    }

    boolean isValid(char[][] board, int row, int col) {
        // column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        // upper left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        // upper right
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }
}