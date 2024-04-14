class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length, col = matrix[0].length;
        int[] r = new int[row], c = new int[col];
        for (int i = 0; i < row; i++) {
            int min = 100001;
            for (int j = 0; j < col; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            r[i] = min;
        }
        for (int j = 0; j < col; j++) {
            int max = 0;
            for (int i = 0; i < row; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            c[j] = max;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == r[i] && matrix[i][j] == c[j])
                    res.add(matrix[i][j]);
            }
        }
        return res;
    }
}