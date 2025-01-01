class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (isEqual(mat, target))
                return true;
            rotate(mat);
        }
        return false;
    }

    boolean isEqual(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j])
                    return false;
            }
        }
        return true;
    }

    void rotate(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; i + j < n - 1; j++) {
                int t = mat[i][j];
                mat[i][j] = mat[n - j - 1][n - i - 1];
                mat[n - j - 1][n - i - 1] = t;
            }
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int t = mat[i][j];
                mat[i][j] = mat[n - i - 1][j];
                mat[n - i - 1][j] = t;
            }
        }
    }
}