class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] row1 = new long[n];
        long[] row2 = new long[n];
        row1[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            row1[i] = row1[i - 1] + grid[0][i];
        }
        row2[n - 1] = grid[1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            row2[i] = row2[i + 1] + grid[1][i];
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, Math.max(row1[n - 1] - row1[i], row2[0] - row2[i]));
        }
        return ans;
    }
}