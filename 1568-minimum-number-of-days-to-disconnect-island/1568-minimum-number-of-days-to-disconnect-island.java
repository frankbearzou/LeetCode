class Solution {
    int m = 0, n = 0;

    public int minDays(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        count = countIsland(grid);
        if (count == 0 || count > 1)
            return 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue;
                grid[i][j] = 0;
                if (countIsland(grid) > 1)
                    return 1;
                grid[i][j] = 1;
            }
        }
        return 2;
    }

    int countIsland(int[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || visited[i][j])
                    continue;
                count++;
                dfs(grid, i, j, visited);
            }
        }
        return count;
    }

    void dfs(int[][] grid, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= m || c < 0 || c >= n)
            return;
        if (grid[r][c] == 0)
            return;
        if (visited[r][c])
            return;
        visited[r][c] = true;
        dfs(grid, r + 1, c, visited);
        dfs(grid, r - 1, c, visited);
        dfs(grid, r, c + 1, visited);
        dfs(grid, r, c - 1, visited);
    }
}