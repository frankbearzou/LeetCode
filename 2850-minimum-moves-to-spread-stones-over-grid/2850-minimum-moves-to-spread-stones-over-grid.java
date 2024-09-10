class Solution {
    public int minimumMoves(int[][] grid) {
        int zero = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 0)
                    zero++;
            }
        }
        if (zero == 0)
            return 0;
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 0) {
                    for (int ii = 0; ii < 3; ii++) {
                        for (int jj = 0; jj < 3; jj++) {
                            if (grid[ii][jj] > 1) {
                                int d = Math.abs(i - ii) + Math.abs(j - jj);
                                grid[i][j]++;
                                grid[ii][jj]--;
                                count = Math.min(count, d + minimumMoves(grid));
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}