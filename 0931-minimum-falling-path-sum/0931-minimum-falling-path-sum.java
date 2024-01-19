class Solution {
    public int minFallingPathSum(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int left = matrix[i - 1][Math.max(0, j - 1)];
                int up = matrix[i - 1][j];
                int right = matrix[i - 1][Math.min(matrix[0].length - 1, j + 1)];
                matrix[i][j] += Math.min(left, Math.min(up, right));
            }
        }
        int min = matrix[matrix.length - 1][0];
        for (int i = 1; i < matrix[0].length; i++) {
            min = Math.min(matrix[matrix.length - 1][i], min);
        }
        return min;
    }
}