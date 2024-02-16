class Solution {
    public void rotate(int[][] matrix) {
        // up and down flip
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - i - 1][j];
                matrix[matrix.length - i - 1][j] = t;
            }
        }
        // up left and down right diagonal flip
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }
}