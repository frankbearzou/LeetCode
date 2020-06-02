class NumMatrix {
    int[][] dp;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        
        dp = new int[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix[0].length; i++)
            dp[0][i] = matrix[0][i];
        
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0];
        }
        
        // left to right
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                dp[i][j] = matrix[i][j] + dp[i][j - 1];
            }
        }
        // top to bottom
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[i][j] = dp[i][j] + dp[i - 1][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int up = row1 == 0 ? 0 : dp[row1 - 1][col2];
        int left = col1 == 0 ? 0 : dp[row2][col1 - 1];
        int overlap = row1 == 0 || col1 == 0 ? 0 : dp[row1 - 1][col1 - 1];
        return dp[row2][col2] - up - left + overlap;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
