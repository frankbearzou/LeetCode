class Solution {
    public int[][] updateMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] = mat.length + mat[0].length;
                }
            }
        }
        // from top left to bottom down
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0)
                    continue;
                if (i > 0) {
                    mat[i][j] = Math.min(mat[i][j], mat[i - 1][j] + 1);
                }
                if (j > 0) {
                    mat[i][j] = Math.min(mat[i][j], mat[i][j - 1] + 1);
                }
            }
        }
        // from botton down to top left
        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                if (mat[i][j] == 0)
                    continue;
                if (i < mat.length - 1) {
                    mat[i][j] = Math.min(mat[i][j], mat[i + 1][j] + 1);
                }
                if (j < mat[0].length - 1) {
                    mat[i][j] = Math.min(mat[i][j], mat[i][j + 1] + 1);
                }
            }
        }
        return mat;
    }
}