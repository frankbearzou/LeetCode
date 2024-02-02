class Solution {
    boolean valid = true;

    public int numEnclaves(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    valid = true;
                    int count = dfs(grid, i, j);
                    if (valid) {
                        ans += count;
                    }
                }
            }
        }
        return ans;
    }

    int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            valid = false;
            return 0;
        }
        if (grid[row][col] == 0)
            return 0;
        grid[row][col] = 0;
        return 1 + dfs(grid, row + 1, col) + dfs(grid, row - 1, col) + dfs(grid, row, col + 1) + dfs(grid, row, col - 1);
    }
}