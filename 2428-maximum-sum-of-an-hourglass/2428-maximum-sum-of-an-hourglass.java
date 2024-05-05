class Solution {
    public int maxSum(int[][] grid) {
        int max = 0;
        for (int i = 0; i <= grid.length - 3; i++) {
            for (int j = 0; j <= grid[0].length - 3; j++) {
                max = Math.max(max, maxSum(grid, i, j));
            }
        }
        return max;
    }

    int maxSum(int[][] grid, int r, int c) {
        int sum = 0;
        sum += grid[r][c] + grid[r][c + 1] + grid[r][c + 2];
        sum += grid[r + 1][c + 1];
        sum += grid[r + 2][c] + grid[r + 2][c + 1] + grid[r + 2][c + 2];
        return sum;
    }
}