class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long ans = 0;
        int min = Integer.MAX_VALUE;
        int count = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < 0) {
                    count++;
                }
                ans += Math.abs(matrix[i][j]);
                min = Math.min(min, Math.abs(matrix[i][j]));
            }
        }
        if (count % 2 == 0)
            return ans;
        return ans - 2 * min;
    }
}