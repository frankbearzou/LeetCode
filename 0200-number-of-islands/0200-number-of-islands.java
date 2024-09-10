class Solution {
    char[][] grid;
    int m;
    int n;
    boolean[][] visited;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    visited = new boolean[m][n];
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n)
            return;
        if (grid[r][c] == '0')
            return;
        if (visited[r][c])
            return;
        visited[r][c] = true;
        grid[r][c] = '0';
        dfs(r + 1, c);
        dfs(r - 1, c);
        dfs(r, c + 1);
        dfs(r, c - 1);
    }
}