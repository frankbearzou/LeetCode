class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int counter = 1;
        int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1;
        
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // top row
            for (int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = counter;
                counter++;
            }
            rowStart++;
            
            // right column
            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = counter;
                counter++;
            }
            colEnd--;
            
            // bottom row
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    matrix[rowEnd][i] = counter;
                    counter++;
                }
            }
            rowEnd--;
            
            // left column
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    matrix[i][colStart] = counter;
                    counter++;
                }
            }
            colStart++;
        }
        
        return matrix;
    }
}
