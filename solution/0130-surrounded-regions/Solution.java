class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        
        // top and bottom row
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O' && !visited[0][i])
                dfs(board, 0, i, visited);
            if (board[row - 1][i] == 'O' && !visited[row - 1][i])
                dfs(board, row - 1, i, visited);
        }
        
        // left and right column
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O' && !visited[i][0])
                dfs(board, i, 0, visited);
            if (board[i][col - 1] == 'O' && !visited[i][col - 1])
                dfs(board, i, col - 1, visited);
        }
        
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    
    private void dfs(char[][] board, int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        
        for (int[] dir : dirs) {
            int newY = row + dir[0];
            int newX = col + dir[1];
            if (newY >= 0 && newY < board.length && newX >= 0 && newX < board[0].length) {
                if (board[newY][newX] == 'O' && !visited[newY][newX]) {
                    dfs(board, newY, newX, visited);
                }
            }
        }
    }
}
