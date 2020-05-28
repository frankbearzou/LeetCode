class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return 0;
        
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                obstacleGrid[i][j] *= -1;
            }
        }
        
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] != -1)
                obstacleGrid[i][0] = 1;
            else
                break;
        }
        
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if(obstacleGrid[0][i] != -1)
                obstacleGrid[0][i] = 1;
            else
                break;
        }
        
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] != -1) {
                    int up = obstacleGrid[i - 1][j] != -1 ? obstacleGrid[i - 1][j] : 0;
                    int left = obstacleGrid[i][j - 1] != -1 ? obstacleGrid[i][j - 1] : 0;
                    obstacleGrid[i][j] = up + left;
                }
            }
        }
        
        int res = obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
        return res != -1 ? res : 0;
    }
}
