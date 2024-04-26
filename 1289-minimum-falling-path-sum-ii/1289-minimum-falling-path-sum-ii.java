class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        for (int i = 1; i < n; i++) {
            int smallest = 100, smaller = 100;
            for (int j = 0; j < n; j++) {
                if (grid[i - 1][j] < smallest) {
                    smaller = smallest;
                    smallest = grid[i - 1][j];
                } else if (grid[i - 1][j] < smaller) {
                    smaller = grid[i - 1][j];
                }
            }
            for (int j = 0; j < n; j++) {
                if (grid[i - 1][j] == smallest) {
                    grid[i][j] += smaller;
                } else {
                    grid[i][j] += smallest;
                }
            }
        }
        int min = 100;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, grid[n - 1][j]);
        }
        return min;
    }
}