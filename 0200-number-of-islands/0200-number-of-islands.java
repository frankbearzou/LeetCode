class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0, row = grid.length, column = grid[0].length;
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1')
                    grid[i][j] = '2';
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '2' && !visited[i][j]) {
                    ans++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int r, int c, boolean[][] visited) {
        int row = grid.length, column = grid[0].length;
        if (r < 0 || r >= row || c < 0 || c >= column)
            return;
        if (grid[r][c] != '2')
            return;
        if (visited[r][c])
            return;
        grid[r][c] = '1';
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : directions) {
            int newR = r + dir[0], newC = c + dir[1];
            dfs(grid, newR, newC, visited);
        }
    }
}