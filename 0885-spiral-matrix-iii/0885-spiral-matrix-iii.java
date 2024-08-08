class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int n = rows * cols;
        int[][] res = new int[n][2];
        res[0] = new int[]{rStart, cStart};
        int index = 1;
        int left = cStart - 1, right = cStart + 1, up = rStart - 1, down = rStart + 1;
        cStart++;
        int i = rStart, j = cStart;
        while (index < n) {
            // right side up to down
            for (; i < down; i++) {
                if (i >= 0 && i < rows && j >= 0 && j < cols) {
                    res[index++] = new int[]{i, j};
                }
            }
            // bottom side right to left
            for (; j > left; j--) {
                if (i >= 0 && i < rows && j >= 0 && j < cols) {
                    res[index++] = new int[]{i, j};
                }
            }
            // left side bottom to top
            for (; i > up; i--) {
                if (i >= 0 && i < rows && j >= 0 && j < cols) {
                    res[index++] = new int[]{i, j};
                }
            }
            // top side left to right
            for (; j <= right; j++) {
                if (i >= 0 && i < rows && j >= 0 && j < cols) {
                    res[index++] = new int[]{i, j};
                }
            }
            left--; right++; up--; down++;
        }
        return res;
    }
}