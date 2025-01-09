class Solution {
    char[][] board;
    String word;
    int m;
    int n;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(int row, int col, int index) {
        if (index == word.length())
            return true;
        if (row < 0 || row >= m || col < 0 || col >= n)
            return false;
        if (visited[row][col])
            return false;
        if (board[row][col] != word.charAt(index))
            return false;
        visited[row][col] = true;
        boolean found = false;
        for (int[] dir : dirs) {
            int dr = row + dir[0];
            int dc = col + dir[1];
            if (dfs(dr, dc, index + 1))
                found = true;
        }
        visited[row][col] = false;
        return found;
    }
}