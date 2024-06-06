class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0, visited))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        if (index == word.length())
            return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return false;
        if (visited[row][col])
            return false;
        if (board[row][col] != word.charAt(index))
            return false;
        boolean found = false;
        visited[row][col] = true;
        for (int[] dir : dirs) {
            if (dfs(board, word, row + dir[0], col + dir[1], index + 1, visited))
                found = true;
        }
        visited[row][col] = false;
        return found;
    }
}