class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        if (row < 3 || col < 3)
            return 0;
        int count = 0;
        for (int i = 0; i <= row - 3; i++) {
            for (int j = 0; j <= col - 3; j++) {
                if (isMagic(grid, i, j))
                    count++;
            }
        }
        return count;
    }

    boolean isMagic(int[][] grid, int r, int c) {
        // row
        for (int i = r; i < r + 3; i++) {
            int sum = 0;
            for (int j = c; j < c + 3; j++) {
                sum += grid[i][j];
            }
            if (sum != 15)
                return false;
        }
        // col
        for (int j = c; j < c + 3; j++) {
            int sum = 0;
            for (int i = r; i < r + 3; i++) {
                sum += grid[i][j];
            }
            if (sum != 15)
                return false;
        }
        // diag
        int sum = 0;
        for (int k = 0; k < 3; k++) {
            sum += grid[r + k][c + k];
        }
        if (sum != 15)
            return false;
        if (grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c] != 15)
            return false;
        return true;
    }
}