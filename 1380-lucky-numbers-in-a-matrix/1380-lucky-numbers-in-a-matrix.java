class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        // fill min row
        for (int i = 0; i < m; i++) {
            row[i] = matrix[i][0];
            for (int j = 0; j < n; j++) {
                row[i] = Math.min(row[i], matrix[i][j]);
            }
        }
        // fill max col
        for (int j = 0; j < n; j++) {
            col[j] = matrix[0][j];
            for (int i = 0; i < m; i++) {
                col[j] = Math.max(col[j], matrix[i][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == col[j]) {
                    res.add(row[i]);
                }
            }
        }
        return res;
    }
}