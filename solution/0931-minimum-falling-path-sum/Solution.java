class Solution {
    public int minFallingPathSum(int[][] A) {
        int min = Integer.MAX_VALUE;
        
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                int left = A[i - 1][Math.max(0, j - 1)];
                int up = A[i - 1][j];
                int right = A[i - 1][Math.min(j + 1, A[0].length - 1)];
                A[i][j] += Math.min(left, Math.min(up, right));
            }
        }
        
        for (int j = 0; j < A[0].length; j++)
            min = Math.min(min, A[A.length - 1][j]);
        
        return min;
    }
}
