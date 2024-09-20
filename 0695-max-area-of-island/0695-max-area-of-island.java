class Solution {
    int m;
    int n;
    int[][] grid;
    int ans;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(i, j));
                }
            }
        }
        return ans;
    }

    int dfs(int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n)
            return 0;
        if (grid[r][c] == 0)
            return 0;
        grid[r][c] = 0;
        return dfs(r - 1, c) + dfs(r + 1, c) + dfs(r, c - 1) + dfs(r, c + 1) + 1;
    }
}