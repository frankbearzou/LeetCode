class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int sum = 0;
        int n = grid.length;
        int[] row = new int[n];
        int[] col = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.min(row[i], col[j]) - grid[i][j];
            }
        }
        return sum;
    }
}