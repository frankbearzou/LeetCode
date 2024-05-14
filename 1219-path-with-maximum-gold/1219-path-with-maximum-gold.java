class Solution {
    int max = 0;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int getMaximumGold(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    dfs(grid, i, j, visited, 0);
                }
            }
        }
        return max;
    }

    void dfs(int[][] grid, int r, int c, boolean[][] visited, int count) {
        int row = grid.length, col = grid[0].length;
        if (r < 0 || r >= row || c < 0 || c >= col)
            return;
        if (grid[r][c] == 0)
            return;
        if (visited[r][c])
            return;
        max = Math.max(max, count + grid[r][c]);
        visited[r][c] = true;
        for (int[] dir : dirs) {
            int newr = r + dir[0];
            int newc = c + dir[1];
            if (newr < 0 || newr >= row || newc < 0 || newc >= col)
                continue;
            dfs(grid, newr, newc, visited, count + grid[r][c]);
        }
        visited[r][c] = false;
    }
}