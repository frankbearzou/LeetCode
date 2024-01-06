class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = -1;
            }
        }
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == -1)
                break;
            obstacleGrid[i][0] = 1;
        }
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == -1)
                break;
            obstacleGrid[0][i] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == -1)
                    continue;
                int left = obstacleGrid[i][j - 1];
                if (left == -1)
                    left = 0;
                int up = obstacleGrid[i - 1][j];
                if (up == -1)
                    up = 0;
                obstacleGrid[i][j] = left + up;
            }
        }
        int ans = obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
        if (ans == -1)
            return 0;
        return ans;
    }
}