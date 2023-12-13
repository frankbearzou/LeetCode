class Solution {
    public void rotate(int[][] matrix) {
        int l = 0, r = matrix.length - 1;
        while (l < r) {
            for (int i = 0; i < r - l; i++) {
                int up = l, down = r;
                int t = matrix[up][l + i];
                // move left down to left up
                matrix[up][l + i] = matrix[down - i][l];
                // move right down to left down
                matrix[down - i][l] = matrix[down][r - i];
                // move right up to right down
                matrix[down][r - i] = matrix[up + i][r];
                // move left up to right down
                matrix[up + i][r] = t;
            }
            l++;
            r--;
        }
    }
}