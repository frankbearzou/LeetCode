class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        // bottom to up
        for (int r = row - 1; r >= 0; r--) {
            int val = matrix[r][0];
            for (int i = r + 1, j = 1; i < row && j < col; i++, j++) {
                if (matrix[i][j] != val)
                    return false;
            }
        }
        // left to right
        for (int c = 1; c < col; c++) {
            int val = matrix[0][c];
            for (int i = 1, j = c + 1; i < row && j < col; i++, j++) {
                if (matrix[i][j] != val)
                    return false;
            }
        }
        return true;
    }
}