class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    int len = Math.min(matrix.length - i, matrix[i].length - j);
                    for (int k = 0; k <= len; k++) {
                        if (!square(matrix, i, j, k))
                            break;
                        max = Math.max(max, k * k);
                    }
                }
            }
        }
        return max;
    }

    private boolean square(char[][] matrix, int row, int col, int len) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (matrix[row + i][col + j] == '0')
                    return false;
            }
        }
        return true;
    }
}
