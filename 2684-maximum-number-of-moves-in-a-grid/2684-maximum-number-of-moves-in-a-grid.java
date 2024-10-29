class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] dp = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = true;
        }
        for (int j = 0; j < n - 1; j++) {
            boolean pass = false;
            for (int i = 0; i < m; i++) {
                if (!dp[i][j])
                    continue;
                if (i > 0 && grid[i][j] < grid[i - 1][j + 1]) {
                    dp[i - 1][j + 1] = true;
                    pass = true;
                }
                if (grid[i][j] < grid[i][j + 1]) {
                    dp[i][j + 1] = true;
                    pass = true;
                }
                if (i < m - 1 && grid[i][j] < grid[i + 1][j + 1]) {
                    dp[i + 1][j + 1] = true;
                    pass = true;
                }
            }
            if (!pass)
                return j;
        }
        return n - 1;
    }
}