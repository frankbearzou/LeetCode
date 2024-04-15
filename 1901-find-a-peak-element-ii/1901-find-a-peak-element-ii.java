class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int top = 0, bottom = m - 1;
        while (top <= bottom) {
            int i = (top + bottom) / 2;
            int j = 0, max = -1;
            for (int k = 0; k < n; k++) {
                if (mat[i][k] > max) {
                    j = k;
                    max = mat[i][k];
                }
            }
            if (i >= 1 && mat[i][j] < mat[i - 1][j]) {
                bottom = i - 1;
                continue;
            }
            if (i + 1 < m && mat[i][j] < mat[i + 1][j]) {
                top = i + 1;
                continue;
            }
            return new int[]{i, j};
        }
        return new int[0];
    }
}