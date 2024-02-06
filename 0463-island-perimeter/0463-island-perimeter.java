class Solution {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        int row = grid.length, col = grid[0].length;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0)
                    continue;
                if (c == 0 || grid[r][c - 1] == 0)
                    ans++;
                if (r == 0 || grid[r - 1][c] == 0)
                    ans++;
                if (c == col - 1 || grid[r][c + 1] == 0)
                    ans++;
                if (r == row - 1 || grid[r + 1][c] == 0)
                    ans++;
            }
        }
        return ans;
    }
}