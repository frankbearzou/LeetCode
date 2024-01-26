class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] cache = new Integer[m][n][maxMove + 1];
        return dfs(m, n, maxMove, startRow, startColumn, cache);
    }

    int dfs(int m, int n, int move, int row, int col, Integer[][][] cache) {
        if (row < 0 || row >= m || col < 0 || col >= n)
            return 1;
        if (move == 0)
            return 0;
        if (cache[row][col][move] != null)
            return cache[row][col][move];
        int ans = 0;
        ans = (ans + dfs(m, n, move - 1, row + 1, col, cache)) % 1_000_000_007;
        ans = (ans + dfs(m, n, move - 1, row - 1, col, cache)) % 1_000_000_007;
        ans = (ans + dfs(m, n, move - 1, row, col + 1, cache)) % 1_000_000_007;
        ans = (ans + dfs(m, n, move - 1, row, col - 1, cache)) % 1_000_000_007;
        cache[row][col][move] = ans;
        return ans;
    }
}