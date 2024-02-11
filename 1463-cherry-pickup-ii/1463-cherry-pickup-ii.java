class Solution {
    public int cherryPickup(int[][] grid) {
        Integer[][][] cache = new Integer[grid.length][grid[0].length][grid[0].length];
        return dfs(grid, 0, 0, grid[0].length - 1, cache);
    }

    int dfs(int[][] grid, int r, int c1, int c2, Integer[][][] cache) {
        if (r == grid.length - 1)
            return grid[r][c1] + grid[r][c2];
        if (cache[r][c1][c2] != null)
            return cache[r][c1][c2];
        int ans = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newc1 = c1 + i;
                int newc2 = c2 + j;
                if (newc1 < 0 || newc1 >= newc2 || newc2 >= grid[0].length)
                    continue;
                ans = Math.max(ans, dfs(grid, r + 1, newc1, newc2, cache));
            }
        }
        return cache[r][c1][c2] = ans + grid[r][c1] + grid[r][c2];
    }
}