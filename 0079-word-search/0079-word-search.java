class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int row;
    int col;

    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, 0, i, j, visited))
                        return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, int index, int r, int c, boolean[][] visited) {
        if (index >= word.length())
            return false;
        if (visited[r][c])
            return false;
        if (index == word.length() - 1 && board[r][c] == word.charAt(index))
            return true;
        if (board[r][c] != word.charAt(index))
            return false;
            visited[r][c] = true;
        for (int[] dir : dirs) {
            int newr = r + dir[0];
            int newc = c + dir[1];
            if (newr < 0 || newr >= row || newc < 0 || newc >= col)
                continue;
            if (dfs(board, word, index + 1, newr, newc, visited))
                return true;
        }
        visited[r][c] = false;
        return false;
    }
}