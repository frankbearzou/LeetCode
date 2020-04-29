class Solution {
    public int[][] imageSmoother(int[][] M) {
        int row = M.length, col = M[0].length;
        int[][] ans = new int[row][col];
        
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                int count = 0, sum = 0, i = 0, j = 0;
                for (i = r - 1; i <= r + 1; i++) {
                    for (j = c - 1; j <= c + 1; j++) {
                        if (i >= 0 && i < row && j >= 0 && j < col) {
                            count++;
                            sum += M[i][j];
                        }
                    }
                }
                ans[r][c] = sum / count;
            }
        }
        
        return ans;
    }
}
