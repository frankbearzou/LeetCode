class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    bfs(board, i, j);
                }
            }
        }
        return count;
    }
    
    private int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    
    private void bfs(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '.')
            return;
        board[row][col] = '.';
        for (int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            bfs(board, r, c);
        }
    }
}
