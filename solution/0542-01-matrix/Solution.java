class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0)
            return matrix;
        int[][] res = new int[matrix.length][matrix[0].length];
        
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = res.length + res[i].length;
            }
        }
        
        // top left to bottom right
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                if (matrix[i][j] == 0)
                    res[i][j] = 0;
                else {
                    if (i > 0)
                        res[i][j] = Math.min(res[i][j], res[i - 1][j] + 1);
                    if (j > 0)
                        res[i][j] = Math.min(res[i][j], res[i][j - 1] + 1);
                }
            }
        }
        
        // botton right to top left
        for (int i = res.length - 1; i >= 0; i--) {
            for (int j = res[i].length - 1; j >= 0; j--) {
                if (matrix[i][j] == 0)
                    res[i][j] = 0;
                else {
                    if (i < res.length - 1)
                        res[i][j] = Math.min(res[i][j], res[i + 1][j] + 1);
                    if (j < res[i].length - 1)
                        res[i][j] = Math.min(res[i][j], res[i][j + 1] + 1);
                }
            }
        }
        
        return res;
    }
}
