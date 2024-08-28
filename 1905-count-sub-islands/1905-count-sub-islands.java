class Solution {
    int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    int[][] grid1;
    int[][] grid2;
    int m, n;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        this.grid1 = grid1;
        this.grid2 = grid2;
        m = grid1.length;
        n = grid1[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs(i, j))
                        count++;
                }
            }
        }
        return count;
    }

    boolean dfs(int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n)
            return true;
        if (grid2[r][c] == 0)
            return true;
        grid2[r][c] = 0;
        boolean left = dfs(r, c - 1);
        boolean right = dfs(r, c + 1);
        boolean up = dfs(r - 1, c);
        boolean down =  dfs(r + 1, c);
        return left && right && up && down && grid1[r][c] == 1;
    }
}