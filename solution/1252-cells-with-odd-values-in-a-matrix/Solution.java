class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int ans = 0;
        int[][] matrix = new int[n][m];
        
        for (int i = 0; i < indices.length; i++) {
            // add row
            for (int j = 0; j < m; j++) {
                matrix[indices[i][0]][j]++;
            }
            //add col
            for (int j = 0; j < n; j++) {
                matrix[j][indices[i][1]]++;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] % 2 == 1)
                    ans++;
            }
        }
        
        return ans;
    }
}
