class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int maxRow = 0, maxColumn = 0, sum = 0;
        
        for (int i = 0; i < grid.length; i++) {
            maxRow = grid[i][0];
            for (int k = 1; k < grid[i].length; k++) {
                if (grid[i][k] > maxRow)
                    maxRow = grid[i][k];
            }
            
            for (int j = 0; j < grid[i].length; j++) {
                maxColumn = grid[0][j];
                for (int k = 1; k < grid.length; k++) {
                    if (grid[k][j] > maxColumn)
                        maxColumn = grid[k][j];
                }
                
                sum += (maxRow > maxColumn ? maxColumn : maxRow) - grid[i][j];
            }
        }
        
        return sum;
    }
}
