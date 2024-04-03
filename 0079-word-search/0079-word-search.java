class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean[][] visited = new boolean[row][col];
                if (dfs(board, i, j, word, 0, visited))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (index == word.length())
            return true;
        int row = board.length, col = board[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col)
            return false;
        if (visited[i][j])
            return false;
        if (board[i][j] != word.charAt(index))
            return false;
        visited[i][j] = true;
        if (dfs(board, i + 1, j, word, index + 1, visited) ||
            dfs(board, i - 1, j, word, index + 1, visited) ||
            dfs(board, i, j + 1, word, index + 1, visited) ||
            dfs(board, i, j - 1, word, index + 1, visited))
            return true;
        return false;
    }
}