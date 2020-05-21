class Solution {
    public int countSquares(int[][] matrix) {
        int count = 0;
        
        for (int k = 0; k < Math.min(matrix[0].length, matrix.length); k++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (i + k < matrix.length && j + k < matrix[0].length)
                        count += dfs(matrix, i, j, k);
                }
            }
        }
        
        return count;
    }
    
    private int dfs(int[][] matrix, int row, int col, int k) {
        for (int i = row; i <= row + k; i++) {
            for (int j = col; j <= col + k; j++) {
                if (matrix[i][j] == 0)
                    return 0;
            }
        }
        return 1;
    }
}
