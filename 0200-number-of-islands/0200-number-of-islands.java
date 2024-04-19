class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    void dfs(char[][] grid, int r, int c) {
        grid[r][c] = '0';
        for (int[] dir : dirs) {
            int newr = r + dir[0];
            int newc = c + dir[1];
            if (newr < 0 || newr >= grid.length || newc < 0 || newc >= grid[0].length || grid[newr][newc] == '0')
                continue;
            dfs(grid, newr, newc);
        }
    }
}