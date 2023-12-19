class Solution {
    public int[][] imageSmoother(int[][] img) {
        int row = img.length, col = img[0].length;
        int[][] ans = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = 0, sum = 0;
                for (int r = Math.max(0, i - 1); r < Math.min(row, i + 2); r++) {
                    for (int c = Math.max(0, j - 1); c < Math.min(col, j + 2); c++) {
                        sum += img[r][c];
                        count++;
                    }
                }
                ans[i][j] = sum / count;
            }
        }
        return ans;
    }
}