class Solution {
    int m, n;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        int num = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    BSF(grid, i, j);
                    ++num;
                }
            }
        }
        
        return num;
    }
    
    private void BSF(char[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        BSF(grid, i - 1, j);
        BSF(grid, i + 1, j);
        BSF(grid, i, j - 1);
        BSF(grid, i, j + 1);
    }
}
