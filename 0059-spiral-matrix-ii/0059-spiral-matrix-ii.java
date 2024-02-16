class Solution {
    int counter = 1;

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int l = 0, r = n - 1, u = 0, d = n - 1;
        while (l <= r && u <= d) {
            print(matrix, l, r, u, d);
            l++;
            r--;
            u++;
            d--;
        }
        return matrix;
    }

    void print(int[][] matrix, int l, int r, int u, int d) {
        if (l == r || u == d) {
            matrix[u][l] = counter++;
        } else {
            // up
            for (int j = l; j < r; j++) {
                matrix[u][j] = counter++;
            }
            // right
            for (int i = u; i < d; i++) {
                matrix[i][r] = counter++;
            }
            // down
            for (int j = r; j > l; j--) {
                matrix[d][j] = counter++;
            }
            // left
            for (int i = d; i > u; i--) {
                matrix[i][l] = counter++;
            }
        }
    }
}