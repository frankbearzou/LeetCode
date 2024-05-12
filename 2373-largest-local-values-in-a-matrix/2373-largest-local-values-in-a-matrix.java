class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] matrix = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                for (int r = i; r <= i + 2; r++) {
                    for (int c = j; c <= j + 2; c++) {
                        if (grid[r][c] > matrix[i][j])
                            matrix[i][j] = grid[r][c];
                    }
                }
            }
        }
        return matrix;
    }
}