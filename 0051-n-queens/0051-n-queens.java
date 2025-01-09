class Solution {
    int n;
    char[][] board;
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        dfs(0);
        return ans;
    }

    void dfs(int row) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s = new String(board[i]);
                list.add(s);
            }
            ans.add(list);
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
        // column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        // left upper
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        //right upper
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }
}