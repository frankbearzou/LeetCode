class Solution {
    private boolean ans = false;
    
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    dfs(board, i, j, word, 0, new boolean[board.length][board[0].length]);
                    if (ans)
                        return true;
                }
            }
        }
        
        return false;
    }
    
    private void dfs(char[][] board, int row, int col, String word, int pos, boolean[][] visited) {
        if (ans)
            return;
        
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || 
            pos >= word.length() || word.charAt(pos) != board[row][col] || visited[row][col]) {
            return;
        }
        
        if (pos == word.length() - 1) {
            ans = true;
            return;
        }
        
        visited[row][col] = true;
        if (row > 0)
            dfs(board, row - 1, col, word, pos + 1, visited);
        if (row < board.length - 1)
            dfs(board, row + 1, col, word, pos + 1, visited);
        if (col > 0)
            dfs(board, row, col - 1, word, pos + 1, visited);
        if (col < board[0].length - 1)
            dfs(board, row, col + 1, word, pos + 1, visited);

        visited[row][col] = false;
    }
}
