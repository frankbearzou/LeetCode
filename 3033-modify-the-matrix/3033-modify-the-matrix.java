class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            boolean neg = false;
            int max = -1;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] > max)
                    max = matrix[i][j];
                if (matrix[i][j] == -1)
                    neg = true;
            }
            if (neg) {
                for (int i = 0; i < matrix.length; i++) {
                    if (matrix[i][j] == -1)
                        matrix[i][j] = max;
                }
            }
        }
        return matrix;
    }
}